package com.xxlspringboot.usermanage.request;

import lombok.Data;

@Data
public class CreateAbilityRequest {
    private String abilityName;
    private double abilityValue;
}
