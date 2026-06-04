package com.moysakuma.notificationcenter.dto.Notifications;

public record NotificationRequest(
    String asunto,
    ConfiguracionNotificacion template
) {
}
