package com.moysakuma.notificationcenter.routes;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.moysakuma.notificationcenter.dto.Onboarding.OboardingCreateRequest;
import com.moysakuma.notificationcenter.dto.Onboarding.OnboardingCreateResponse;

@Component

public class OnboardingReceptionRoute extends RouteBuilder {

        @Override
        public void configure() {
                restConfiguration()
                        .component("servlet")
                        .contextPath("/notificacion")
                        .bindingMode(RestBindingMode.json)
                        .apiContextPath("/api-doc")
                        .apiProperty("api.title", "Notification Center Onboarding API")
                        .apiProperty("api.version", "1.0.0")
                        .apiProperty("cors", "true");
        
        rest("/onboarding")
                .post()
                .description("Alta de servicio dentro del notification center")
                .type(OboardingCreateRequest.class)
                .outType(OnboardingCreateResponse.class)
                .to("direct:receiveOnboarding");

        from("direct:receiveOnboarding")
                .routeId("onboarding-reception")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
                .process(exchange -> exchange.getMessage().setBody(new OnboardingCreateResponse( UUID.randomUUID().toString(), "RECEIVED", "Onboarding request received successfully")));
                
    }
}