import java.util.Scanner;

public class AuthService {
    private final String usuarioPadrao = "admin";
    private final String senhaCriptografada = CryptoService.hashSenha("senha123");

    public boolean login(Scanner scanner) {
        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (usuario.equals(usuarioPadrao) && CryptoService.verificarSenha(senha, senhaCriptografada)) {
            // Cria instância de autenticação 2FA
            TwoFactorAuth twoFA = new TwoFactorAuth();
            return twoFA.run2FA(usuario); // executa o 2FA real
        }

        System.out.println("Usuário ou senha inválidos.");
        return false;
    }
}
