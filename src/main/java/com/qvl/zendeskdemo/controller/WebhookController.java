package com.qvl.zendeskdemo.controller;

import com.qvl.zendeskdemo.dto.CreateWebhookRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WebhookController {
    @Value("${webhook.create-uri}")
    private String createWebhookUri;

    @Value("${zendesk.subdomain}")
    private String subDomain;

    @Value("${zendesk.email}")
    private String email;

    @Value("${zendesk.api-token}")
    private String apiToken;

    @Value("${zendesk.end-point}")
    private String endPoint;

    @PostMapping("/webhook")
    public String createWebhook(@Valid @RequestBody CreateWebhookRequest request) {
        String userAuth = email + "/token:" + apiToken;
        String basicAuth = Base64.getEncoder().encodeToString(userAuth.getBytes());

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(basicAuth);
        Map<String, Object> data = new HashMap<>();
        data.put("name",request.getWebhookName());
        data.put("status", request.getStatus().toString().toLowerCase());
        data.put("endpoint", endPoint);
        data.put("http_method", "POST");
        data.put("request_format", "json");
        data.put("subscriptions", Arrays.asList("conditional_ticket_events"));

        Map<String,Object> body = new HashMap<>();
        body.put("webhook", data);

        String response;
        try {
            response = restTemplate.postForObject(
                    subDomain + createWebhookUri,
                    new HttpEntity<>(body, headers),
                    String.class);
        }catch(Exception e){
            response = e.getMessage();
        }
        return response;
    }
}
