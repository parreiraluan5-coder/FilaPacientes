class FilaClinicaVetor {
    private Paciente[] fila;
    private int tamanhoAtual;

    public FilaClinicaVetor(int capacidadeMaxima) {
        this.fila = new Paciente[capacidadeMaxima];
        this.tamanhoAtual = 0;
    }

    // Inserir no final da fila
    public void adicionarChegada(Paciente paciente) {
        if (tamanhoAtual >= fila.length) {
            System.out.println("A fila está cheia!");
            return;
        }
        fila[tamanhoAtual] = paciente;
        tamanhoAtual++;
        System.out.println(paciente.nome + " entrou no final da fila.");
    }

    // Inserir em uma posição específica (Prioridade)
    public void adicionarPrioridade(Paciente paciente, int posicao) {
        if (tamanhoAtual >= fila.length || posicao < 0 || posicao > tamanhoAtual) {
            System.out.println("Erro ao inserir na posição.");
            return;
        }

        // Empurra os elementos para trás para abrir espaço
        for (int i = tamanhoAtual; i > posicao; i--) {
            fila[i] = fila[i - 1];
        }

        fila[posicao] = paciente;
        tamanhoAtual++;
        System.out.println(paciente.nome + " inserido na posição " + posicao + " por prioridade.");
    }

    // Localizar paciente pelo nome
    public Paciente buscarPorNome(String nome) {
        for (int i = 0; i < tamanhoAtual; i++) {
            if (fila[i].nome.equalsIgnoreCase(nome)) {
                System.out.println("Paciente " + nome + " encontrado na posição " + i);
                return fila[i];
            }
        }
        System.out.println("Paciente " + nome + " não encontrado.");
        return null;
    }

    // Remover paciente (Desistência ou chamado fora de ordem)
    public void removerPaciente(String nome) {
        int posicaoRemocao = -1;

        for (int i = 0; i < tamanhoAtual; i++) {
            if (fila[i].nome.equalsIgnoreCase(nome)) {
                posicaoRemocao = i;
                break;
            }
        }

        if (posicaoRemocao == -1) {
            System.out.println("Paciente não encontrado para remoção.");
            return;
        }

        System.out.println("Paciente " + fila[posicaoRemocao].nome + " saiu da fila.");

        // Puxa os elementos da frente para cobrir o buraco do que saiu
        for (int i = posicaoRemocao; i < tamanhoAtual - 1; i++) {
            fila[i] = fila[i + 1];
        }

        fila[tamanhoAtual - 1] = null;
        tamanhoAtual--;
    }

    // Imprime os dados acessando diretamente as variáveis do Paciente
    public void exibirFila() {
        if (tamanhoAtual == 0) {
            System.out.println("Fila vazia.");
            return;
        }
        System.out.println("\n--- FILA ATUAL ---");
        for (int i = 0; i < tamanhoAtual; i++) {
            // Acessando diretamente as propriedades sem usar toString()
            System.out.println("[" + i + "] Nome: " + fila[i].nome + " | Idade: " + fila[i].idade + " | Esp: " + fila[i].especialidade);
        }
        System.out.println("------------------\n");
    }
}