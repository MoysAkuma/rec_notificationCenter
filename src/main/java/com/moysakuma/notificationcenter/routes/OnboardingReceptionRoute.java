package com.moysakuma.notificationcenter.routes;
import java.util.UUID;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component

public class OnboardingReceptionRoute extends RouteBuilder {

        /*rest("/onboarding")
                .post()
                .description("Alta de servicio dentro del notification center")
                .type(OnboardingCreateRequest.class)
                .outType(OnboardingCreateResponse.class)
                .to("direct:receiveOnboarding");

        from("direct:receiveOnboarding")
                .routeId("onboarding-reception")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
                .process(exchange -> exchange.getMessage().setBody(new OnboardingCreateResponse(UUID.randomUUID().toString(), "RECEIVED")));
                */
    }
}