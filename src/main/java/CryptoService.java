import org.mindrot.jbcrypt.BCrypt;

public class CryptoService {

    public static String hashSenha(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public static boolean verificarSenha(String senhaDigitada, String senhaHash) {
        return BCrypt.checkpw(senhaDigitada, senhaHash);
    }
}
