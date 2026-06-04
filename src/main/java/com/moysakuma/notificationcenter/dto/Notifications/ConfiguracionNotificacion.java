package com.moysakuma.notificationcenter.dto.Notifications;

public record ConfiguracionNotificacion(
    String nombre_plantilla,
    CreateValores[] valores
) {

}
