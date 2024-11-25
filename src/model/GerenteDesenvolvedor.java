package model;

public class GerenteDesenvolvedor extends Funcionario implements Gerencia, Desenvolve {
    public GerenteDesenvolvedor(String nome, double salario) {
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
    public void codar() {
        System.out.println(getNome() + " está codando.");
    }

    @Override
    public void resolverProblemas() {
        System.out.println(getNome() + " está resolvendo problemas técnicos.");
    }

    @Override
    public String mostrarDetalhes() {
        return String.format("ID: %d | Gerente Desenvolvedor | Nome: %s | Salário: %.2f", getId(), getNome(), getSalario());
    }
}
