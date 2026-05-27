package com.moysakuma.notificationcenter;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NotificationReceptionRouteTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReceiveNotificationUsingCamelRestEndpoint() {
        Map<String, String> payload = Map.of(
                "recipient", "user@example.com",
                "channel", "EMAIL",
                "message", "hola"
        );

        ResponseEntity<Map> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/notifications",
                new HttpEntity<>(payload),
                Map.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
        assertThat(response.getBody()).containsEntry("status", "RECEIVED");
        assertThat(response.getBody()).containsKey("notificationId");
    }

    @Test
    void shouldExposeSwaggerContractFile() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/swagger/notification-center.yaml",
                String.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).contains("openapi: 3.0.3");
        assertThat(response.getBody()).contains("/notifications");
    }
}
