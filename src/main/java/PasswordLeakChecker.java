public class PasswordLeakChecker {
    public static void verificarVazamento(String senha) {
        System.out.println("(Simulado) Verificando vazamento da senha...");
        if (senha.equals("123456") || senha.equalsIgnoreCase("senha123")) {
            System.out.println("⚠️ Senha fraca ou exposta!");
        } else {
            System.out.println("✅ Senha parece segura.");
        }
    }
}