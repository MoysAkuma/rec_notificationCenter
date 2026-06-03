package com.moysakuma.notificationcenter.dto.Send;

public record NotificacionEnviada(
    String notificationId,
    String templateId,
    String correo_destino,
    String hora_envio,
    String asunto,
    String html_body,
    track[] track
) {

}
