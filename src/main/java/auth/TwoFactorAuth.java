package auth;

// Importar a biblioteca do Google Authenticator
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

import java.util.Scanner;

public class TwoFactorAuth {
    private final GoogleAuthenticator gAuth = new GoogleAuthenticator();
    private final GoogleAuthenticatorKey key;

    public TwoFactorAuth() {
        this.key = gAuth.createCredentials();
    }

    public String getSecret() {
        return key.getKey();
    }

    public boolean validateCode(int code) {
        return gAuth.authorize(key.getKey(), code);
    }

    public boolean run2FA(String user, Scanner scanner) {
        System.out.println("Insira o código abaixo no Google Authenticator:");
        System.out.println("Código secreto: " + getSecret());
        System.out.print("Digite o código gerado no app: ");
        String input = scanner.nextLine();

        int code;

        // Gera uma exceção caso o usuário digite algo sem ser números
        try {
            code = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite apenas números.");
            return false;
        }

        // Valida e mostra o resultado
        boolean valid = validateCode(code);
        if (valid) {
            System.out.println("Código válido! Acesso permitido.");
        } else {
            System.out.println("Código inválido! Acesso negado.");
        }
        return valid;
    }
}
