package padroes.bridge;

public class NotificacaoCancelamento extends Notificacao {

    public NotificacaoCancelamento(CanalEnvio canalEnvio) {
        super(canalEnvio);
    }

    @Override
    public String enviar(String destinatario, String servico) {
        return canalEnvio.enviar(destinatario, "Agendamento cancelado: " + servico);
    }
}
