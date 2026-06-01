public class Main {
    public static void main(String[] args) {
        FilaClinicaVetor fila = new FilaClinicaVetor(5);

        fila.adicionarChegada(new Paciente("João", 45, "Geral"));
        fila.adicionarChegada(new Paciente("Maria", 30, "Dermatologista"));
        fila.adicionarChegada(new Paciente("Carlos", 50, "Cardiologista"));
        fila.exibirFila();

        fila.adicionarPrioridade(new Paciente("Ana (Idosa)", 75, "Geral"), 1);
        fila.exibirFila();

        fila.buscarPorNome("Maria");

        fila.removerPaciente("Carlos");
        fila.exibirFila();
    }
}