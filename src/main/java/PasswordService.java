import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class PasswordService {
    private final Map<String, Map<String, String>> senhas = new HashMap<>();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void salvarSenha(String servico, String usuario, String senha) {
        String senhaHash = org.mindrot.jbcrypt.BCrypt.hashpw(senha, org.mindrot.jbcrypt.BCrypt.gensalt());

        // Atualiza mapa
        Map<String, String> dados = new HashMap<>();
        dados.put("usuario", usuario);
        dados.put("senhaHash", senhaHash);
        senhas.put(servico, dados);

        // Salva em disco
        PasswordStorage.salvarEmArquivo(senhas);

        System.out.println("Senha salva com sucesso para o serviço: " + servico);
    }

    public void listarSenhas() {
        System.out.println("Serviços cadastrados:");
        for (String servico : senhas.keySet()) {
            Map<String, String> dados = senhas.get(servico);
            System.out.println("- " + servico + " (usuário: " + dados.get("usuario") + ")");
        }
    }

    public void carregarSenhas() {
        Map<String, Map<String, String>> dados = PasswordStorage.carregarDoArquivo();
        if (dados != null) {
            senhas.putAll(dados);
        }
    }
}
