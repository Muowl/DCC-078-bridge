package padroes.bridge;

import java.util.Objects;

public class CentralNotificacoes {

    private final Notificacao notificacao;

    public CentralNotificacoes(Notificacao notificacao) {
        this.notificacao = Objects.requireNonNull(notificacao, "Notificação obrigatória");
    }

    public String notificar(String destinatario, String servico) {
        return notificacao.enviar(destinatario, servico);
    }
}
