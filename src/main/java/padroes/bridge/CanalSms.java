package padroes.bridge;

public class CanalSms implements CanalEnvio {

    @Override
    public String enviar(String destinatario, String mensagem) {
        return "SMS para " + destinatario + ": " + mensagem;
    }
}
