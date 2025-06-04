// Importa a autenticação, geração de senhas e verificação de vazamentos
import auth.TwoFactorAuth;
import generator.PasswordGenerator;
import leak.PasswordLeakChecker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Carrega o arquivo JSON (se houver)
        PasswordService passwordService = new PasswordService();
        passwordService.carregarSenhas();

        System.out.println("AUTENTICAÇÃO");
        System.out.print("Digite seu nome de usuário para configurar: ");
        String nomeUsuario = scanner.nextLine();

        // Executa a autenticação
        TwoFactorAuth twoFA = new TwoFactorAuth();
        if (!twoFA.run2FA(nomeUsuario)) {
            System.out.println("Acesso negado.");
            return; // Encerra o programa caso falhe
        }

        boolean executando = true;
        while (executando) {
            System.out.println("\nGERENCIADOR DE SENHAS");
            System.out.println("1. Adicionar nova senha");
            System.out.println("2. Listar serviços salvos");
            System.out.println("3. Gerar senha");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                // Cadastra a senha, o serviço e o usuário
                case "1":
                    System.out.print("Nome do serviço (ex: Gmail): ");
                    String servico = scanner.nextLine();
                    System.out.print("Nome de usuário: ");
                    String user = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    // Verifica se a senha foi vazada
                    boolean vazada = PasswordLeakChecker.verificarVazamento(senha);

                    // Usuário escolhe se continua com a senha vazada ou cria outra
                    // Caso continue, a senha é salva
                    if (vazada) {
                        System.out.print("Deseja continuar com essa senha mesmo assim? (s/n): ");
                        String resposta = scanner.nextLine();
                        if (!resposta.equalsIgnoreCase("s")) {
                            System.out.println("Senha não salva.");
                            break;
                        }
                    }
                    // Salva a senha no arquivo JSON
                    passwordService.salvarSenha(servico, user, senha);
                    break;

                case "2":
                    // Lista os serviços cadastrados
                    passwordService.listarSenhas();
                    break;

                case "3":
                    // Gera uma senha de 8 caracteres
                    String senhaGerada = PasswordGenerator.gerarSenha(8);
                    System.out.println("Senha gerada: " + senhaGerada);

                    break;

                case "4":
                    // Encerra o programa
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
