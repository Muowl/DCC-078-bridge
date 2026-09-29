package padroes.bridge;

import java.util.Objects;

public abstract class Notificacao {

    protected final CanalEnvio canalEnvio;

    protected Notificacao(CanalEnvio canalEnvio) {
        this.canalEnvio = Objects.requireNonNull(canalEnvio, "Canal de envio obrigatório");
    }

    public abstract String enviar(String destinatario, String servico);
}
