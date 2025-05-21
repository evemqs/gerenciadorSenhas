import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();
        PasswordService passwordService = new PasswordService();

        System.out.println("Bem-vindo ao Gerenciador de Senhas!");

        if (!authService.login(scanner)) {
            System.out.println("Falha na autenticação.");
            return;
        }

        System.out.println("Login bem-sucedido!");

        while (true) {
            System.out.println("\n1. Adicionar senha\n2. Gerar senha forte\n3. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Serviço: ");
                String servico = scanner.nextLine();
                System.out.print("Senha: ");
                String senha = scanner.nextLine();

                passwordService.salvarSenha(servico, senha);
            } else if (opcao == 2) {
                String senhaForte = passwordService.gerarSenhaForte();
                System.out.println("Senha gerada: " + senhaForte);
            } else {
                break;
            }
        }

        scanner.close();
    }
}