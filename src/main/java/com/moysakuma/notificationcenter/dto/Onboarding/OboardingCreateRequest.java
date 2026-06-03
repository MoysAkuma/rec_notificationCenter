package com.moysakuma.notificationcenter.dto.Onboarding;

public record OboardingCreateRequest (
        String nombre,
        String email,
        String password,
        String servicio,
        Configuracion configuracion,
        Contacto contacto,
        Susbcripcion subscripcion
){

}
