import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordService passwordService = new PasswordService();
        passwordService.carregarSenhas();

        System.out.println("AUTENTICAÇÃO 2FA");
        System.out.print("Digite seu nome de usuário para configurar: ");
        String nomeUsuario = scanner.nextLine();

        TwoFactorAuth twoFA = new TwoFactorAuth();
        if (!twoFA.run2FA(nomeUsuario)) {
            System.out.println("Acesso negado.");
            return;
        }

        boolean executando = true;
        while (executando) {
            System.out.println("\nGERENCIADOR DE SENHAS");
            System.out.println("1. Adicionar nova senha");
            System.out.println("2. Listar serviços salvos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Nome do serviço (ex: Gmail): ");
                    String servico = scanner.nextLine();
                    System.out.print("Nome de usuário: ");
                    String user = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    passwordService.salvarSenha(servico, user, senha);
                    break;

                case "2":
                    passwordService.listarSenhas();
                    break;

                case "3":
                    System.out.println("Encerrando...");
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
