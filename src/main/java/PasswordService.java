import java.util.Random;

public class PasswordService {
    public void salvarSenha(String servico, String senha) {
        System.out.println("Senha para " + servico + " salva (simulado): " + senha);
        PasswordLeakChecker.verificarVazamento(senha);
    }

    public String gerarSenhaForte() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";
        StringBuilder senha = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 12; i++) {
            senha.append(caracteres.charAt(rand.nextInt(caracteres.length())));
        }
        return senha.toString();
    }
}