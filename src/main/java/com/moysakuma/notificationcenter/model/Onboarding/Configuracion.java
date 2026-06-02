package com.moysakuma.notificationcenter.model.Onboarding;

public record Configuracion(
    String correo,
    String remitente,
    String password,
    String recipiente_pruebas,
    String correo_pruebas,
    String password_pruebas
) {

}
