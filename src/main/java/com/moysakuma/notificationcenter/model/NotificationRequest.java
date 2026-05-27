package com.moysakuma.notificationcenter.model;

public record NotificationRequest(String recipient, String channel, String message) {
}
