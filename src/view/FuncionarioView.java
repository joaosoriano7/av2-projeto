package view;

import java.util.Scanner;

public class FuncionarioView {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Listar Funcionários");
        System.out.println("3. Atualizar Funcionário");
        System.out.println("4. Remover Funcionário");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public String capturarTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.next();
    }

    public int capturarInteiro(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextInt();
    }

    public double capturarDouble(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextDouble();
    }
}
