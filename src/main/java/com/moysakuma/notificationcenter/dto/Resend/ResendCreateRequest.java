package com.moysakuma.notificationcenter.dto.Resend;

import com.moysakuma.notificationcenter.dto.commons.Valores;

public record ResendCreateRequest(
    String reemplaza_template,
    String reemplaza_correo_destino,
    String reemplaza_hora_envio,
    Valores[] reemplaza_valores
) {

}
