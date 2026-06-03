package com.moysakuma.notificationcenter.dto.Notifications;

public record NotificationRequest(String recipient, String channel, String message) {
}
