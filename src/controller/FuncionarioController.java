package controller;

import model.*;
import view.FuncionarioView;

import java.io.*;
import java.util.ArrayList;

public class FuncionarioController {
    private final ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private final FuncionarioView view = new FuncionarioView();
    private final String arquivo = "funcionarios.txt";

    public FuncionarioController() {
        carregarDados();
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = view.mostrarMenu();
            switch (opcao) {
                case 1 -> cadastrarFuncionario();
                case 2 -> listarFuncionarios();
                case 3 -> atualizarFuncionario();
                case 4 -> removerFuncionario();
                case 5 -> salvarDados();
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private void cadastrarFuncionario() {
        int id = funcionarios.size() + 1;
        String nome = view.capturarTexto("Nome: ");
        double salario = view.capturarDouble("Salário: ");
        String tipo = view.capturarTexto("Tipo (Desenvolvedor/Gerente): ");

        Funcionario funcionario;
        switch (tipo.toLowerCase()) {
            case "desenvolvedor" -> funcionario = new Desenvolvedor(id, nome, salario);
            case "gerente" -> funcionario = new Gerente(id, nome, salario);
            default -> {
                System.out.println("Tipo inválido!");
                return;
            }
        }
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            funcionarios.forEach(Funcionario::mostrarDetalhes);
        }
    }

    private void atualizarFuncionario() {
        int id = view.capturarInteiro("ID do funcionário a atualizar: ");
        Funcionario funcionario = buscarFuncionario(id);
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado!");
            return;
        }
        String novoNome = view.capturarTexto("Novo nome: ");
        double novoSalario = view.capturarDouble("Novo salário: ");
        funcionario.setNome(novoNome);
        funcionario.setSalario(novoSalario);
        System.out.println("Funcionário atualizado com sucesso!");
    }

    private void removerFuncionario() {
        int id = view.capturarInteiro("ID do funcionário a remover: ");
        Funcionario funcionario = buscarFuncionario(id);
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado!");
            return;
        }
        funcionarios.remove(funcionario);
        System.out.println("Funcionário removido com sucesso!");
    }

    private Funcionario buscarFuncionario(int id) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Funcionario funcionario : funcionarios) {
                writer.write(funcionario.getId() + ";" + funcionario.getClass().getSimpleName() + ";" + funcionario.getNome() + ";" + funcionario.getSalario());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private void carregarDados() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                int id = Integer.parseInt(dados[0]);
                String tipo = dados[1];
                String nome = dados[2];
                double salario = Double.parseDouble(dados[3]);

                Funcionario funcionario = switch (tipo.toLowerCase()) {
                    case "desenvolvedor" -> new Desenvolvedor(id, nome, salario);
                    case "gerente" -> new Gerente(id, nome, salario);
                    default -> null;
                };
                if (funcionario != null) funcionarios.add(funcionario);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
        }
    }
}
