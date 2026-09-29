package padroes.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CentralNotificacoesTest {

    @Test
    void deveNotificarAgendamentoPorEmail() {
        CentralNotificacoes central = new CentralNotificacoes(
                new NotificacaoAgendamento(new CanalEmail()));

        assertEquals("E-mail para ana@example.com: Agendamento confirmado: Consulta",
                central.notificar("ana@example.com", "Consulta"));
    }

    @Test
    void deveNotificarAgendamentoPorSms() {
        CentralNotificacoes central = new CentralNotificacoes(
                new NotificacaoAgendamento(new CanalSms()));

        assertEquals("SMS para 32999990000: Agendamento confirmado: Consulta",
                central.notificar("32999990000", "Consulta"));
    }

    @Test
    void deveNotificarCancelamentoPorEmail() {
        CentralNotificacoes central = new CentralNotificacoes(
                new NotificacaoCancelamento(new CanalEmail()));

        assertEquals("E-mail para ana@example.com: Agendamento cancelado: Consulta",
                central.notificar("ana@example.com", "Consulta"));
    }

    @Test
    void deveNotificarCancelamentoPorSms() {
        CentralNotificacoes central = new CentralNotificacoes(
                new NotificacaoCancelamento(new CanalSms()));

        assertEquals("SMS para 32999990000: Agendamento cancelado: Consulta",
                central.notificar("32999990000", "Consulta"));
    }

    @Test
    void deveCompartilharCanalEntreTiposDeNotificacao() {
        CanalEnvio canal = new CanalEmail();
        Notificacao agendamento = new NotificacaoAgendamento(canal);
        Notificacao cancelamento = new NotificacaoCancelamento(canal);

        assertEquals("E-mail para ana@example.com: Agendamento confirmado: Consulta",
                agendamento.enviar("ana@example.com", "Consulta"));
        assertEquals("E-mail para ana@example.com: Agendamento cancelado: Consulta",
                cancelamento.enviar("ana@example.com", "Consulta"));
    }

    @Test
    void deveAceitarNovoCanalSemAlterarNotificacoes() {
        CanalEnvio canal = (destinatario, mensagem) -> "Aplicativo para "
                + destinatario + ": " + mensagem;

        assertEquals("Aplicativo para Ana: Agendamento confirmado: Consulta",
                new NotificacaoAgendamento(canal).enviar("Ana", "Consulta"));
        assertEquals("Aplicativo para Ana: Agendamento cancelado: Consulta",
                new NotificacaoCancelamento(canal).enviar("Ana", "Consulta"));
    }

    @Test
    void deveRejeitarCanalAusente() {
        assertThrows(NullPointerException.class, () -> new NotificacaoAgendamento(null));
        assertThrows(NullPointerException.class, () -> new NotificacaoCancelamento(null));
    }

    @Test
    void deveRejeitarNotificacaoAusente() {
        assertThrows(NullPointerException.class, () -> new CentralNotificacoes(null));
    }
}
