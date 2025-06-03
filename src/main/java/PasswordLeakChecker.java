public class PasswordLeakChecker {
    public static boolean verificarVazamento(String senha) {
        System.out.println("Verificando vazamento da senha com Have I Been Pwned...");
        boolean vazada = HIBPClient.senhaVazada(senha);

        if (vazada) {
            System.out.println("Senha encontrada em vazamentos conhecidos!");
        } else {
            System.out.println("Senha não encontrada em vazamentos conhecidos.");
        }

        return vazada;
    }
}