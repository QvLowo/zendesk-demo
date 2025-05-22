package com.qvl.zendeskdemo.dto;

import com.qvl.zendeskdemo.constant.WebhookStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateWebhookRequest {
    @NotBlank
    private String webhookName;
    @NotNull
    private WebhookStatus status;

}
