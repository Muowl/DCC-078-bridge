package padroes.bridge;

public class NotificacaoAgendamento extends Notificacao {

    public NotificacaoAgendamento(CanalEnvio canalEnvio) {
        super(canalEnvio);
    }

    @Override
    public String enviar(String destinatario, String servico) {
        return canalEnvio.enviar(destinatario, "Agendamento confirmado: " + servico);
    }
}
