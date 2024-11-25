package model;

public class Treinador extends Funcionario implements Treina {
    public Treinador(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void ensinarTecnologia() {
        System.out.println(getNome() + " está ensinando novas tecnologias.");
    }

    @Override
    public void motivarEquipe() {
        System.out.println(getNome() + " está motivando a equipe.");
    }

    @Override
    public String mostrarDetalhes() {
        return String.format("ID: %d | Treinador | Nome: %s | Salário: %.2f", getId(), getNome(), getSalario());
    }
}
