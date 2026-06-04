package com.moysakuma.notificationcenter.routes;

import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.moysakuma.notificationcenter.dto.Notifications.NotificationRequest;
import com.moysakuma.notificationcenter.dto.Notifications.NotificationResponse;

@Component
public class NotificationReceptionRoute extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration()
                .component("servlet")
                .contextPath("/notificacion")
                .bindingMode(RestBindingMode.json)
                .apiContextPath("/api-doc")
                .apiProperty("api.title", "Notification Center Reception API")
                .apiProperty("api.version", "1.0.0")
                .apiProperty("cors", "true");

        rest("/notification")
                .post()
                .description("Creacion de notificacion")
                .type(NotificationRequest.class)
                .outType(NotificationResponse.class)
                .to("direct:receiveNotification");

        from("direct:receiveNotification")
                .routeId("notification-reception")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
                .process(exchange -> exchange.getMessage().setBody(new NotificationResponse(UUID.randomUUID().toString(), "RECEIVED", "Notification request received successfully")));
    }
}
