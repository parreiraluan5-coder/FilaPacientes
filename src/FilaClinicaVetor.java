import java.util.LinkedList;

class FilaClinicaVetor {
    private LinkedList<Paciente> fila = new LinkedList<>();

    public FilaClinicaVetor(int capacidadeMaxima) {
    }

    public void adicionarChegada(Paciente paciente) {
        fila.addLast(paciente);
        System.out.println(paciente.nome + " entrou no final da fila.");
    }

    public void adicionarPrioridade(Paciente paciente, int posicao) {
        if (posicao >= 0 && posicao <= fila.size()) {
            fila.add(posicao, paciente);
            System.out.println(paciente.nome + " inserido na posição " + posicao + " por prioridade.");
        } else {
            System.out.println("Posição inválida.");
        }
    }

    public Paciente buscarPorNome(String nome) {
        for (int i = 0; i < fila.size(); i++) {
            if (fila.get(i).nome.equalsIgnoreCase(nome)) {
                System.out.println("Paciente " + nome + " encontrado na posição " + i);
                return fila.get(i);
            }
        }
        System.out.println("Paciente " + nome + " não encontrado.");
        return null;
    }

    public void removerPaciente(String nome) {
        boolean removido = fila.removeIf(paciente -> paciente.nome.equalsIgnoreCase(nome));

        if (removido) {
            System.out.println("Paciente " + nome + " saiu da fila.");
        } else {
            System.out.println("Paciente " + nome + " não estava na fila.");
        }
    }

    public void exibirFila() {
        if (fila.isEmpty()) {
            System.out.println("Fila vazia.");
            return;
        }
        System.out.println("\n--- FILA ATUAL ---");
        for (int i = 0; i < fila.size(); i++) {
            Paciente p = fila.get(i);
            System.out.println("[" + i + "] Nome: " + p.nome + " | Idade: " + p.idade + " | Esp: " + p.especialidade);
        }
        System.out.println("------------------\n");
    }
}