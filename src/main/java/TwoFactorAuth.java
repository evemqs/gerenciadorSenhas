import java.util.Scanner;

public class TwoFactorAuth {
    public static boolean verificarCodigo(Scanner scanner) {
        int codigoGerado = 123456; // Simulado (substitua por Google Authenticator real)
        System.out.print("Digite o código 2FA (123456): ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        return codigo == codigoGerado;
    }
}