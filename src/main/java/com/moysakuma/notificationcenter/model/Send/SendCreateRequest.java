package com.moysakuma.notificationcenter.model.Send;

public record SendCreateRequest(
    String notificationId,
    String templateId,
    String correo_destino,
    String hora_envio,
    Valores[] valores
) {

}
