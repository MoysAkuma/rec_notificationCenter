package com.moysakuma.notificationcenter.dto.Send;

import com.moysakuma.notificationcenter.dto.commons.Valores;

public record SendCreateRequest(
    String notificationId,
    String templateId,
    String correo_destino,
    String hora_envio,
    Valores[] valores
) {

}
