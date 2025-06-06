package leak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class PwnedPassword {

    // Verifica se a senha foi vazada
    public static boolean senhaVazada(String senha) {
        try {
            String hash = sha1(senha).toUpperCase();
            String prefixo = hash.substring(0, 5);
            String sufixo = hash.substring(5);

            // Consulta a API para obter a lista de hashes vazados
            URL url = new java.net.URI("https", "api.pwnedpasswords.com", "/range/" + prefixo, null).toURL();
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setRequestProperty("User-Agent", "PasswordManagerApp");

            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream(), StandardCharsets.UTF_8));
            String linha;
            while ((linha = in.readLine()) != null) {
                // Se a linha tiver o sufixo do hash a senha foi vazada
                if (linha.startsWith(sufixo)) {
                    in.close();
                    return true;
                }
            }
            in.close();

        } catch (Exception e) {
            System.out.println("Erro ao verificar a senha: " + e.getMessage());
        }

        return false;
    }

    private static String sha1(String senha) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] bytes = md.digest(senha.getBytes(StandardCharsets.UTF_8));

        StringBuilder resultado = new StringBuilder();
        for (byte b : bytes) {
            resultado.append(String.format("%02x", b));
        }
        return resultado.toString();
    }
}