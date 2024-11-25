package model;

public class Gerente extends Funcionario implements Gerencia {
    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void organizarEquipe() {
        System.out.println(getNome() + " está organizando a equipe.");
    }

    @Override
    public void conduzirReunioes() {
        System.out.println(getNome() + " está conduzindo reuniões.");
    }

    @Override
    public String mostrarDetalhes() {
        return String.format("ID: %d | Gerente | Nome: %s | Salário: %.2f", getId(), getNome(), getSalario());
    }
}
