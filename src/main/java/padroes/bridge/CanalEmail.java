package padroes.bridge;

public class CanalEmail implements CanalEnvio {

    @Override
    public String enviar(String destinatario, String mensagem) {
        return "E-mail para " + destinatario + ": " + mensagem;
    }
}
