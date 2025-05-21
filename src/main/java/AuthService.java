import java.util.Scanner;

public class AuthService {
    private final String usuarioPadrao = "admin";
    private final String senhaPadrao = "senha123";

    public boolean login(Scanner scanner) {
        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (usuario.equals(usuarioPadrao) && senha.equals(senhaPadrao)) {
            return TwoFactorAuth.verificarCodigo(scanner);
        }
        return false;
    }
}