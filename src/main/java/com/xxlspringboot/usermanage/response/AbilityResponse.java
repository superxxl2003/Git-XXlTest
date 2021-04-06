package com.xxlspringboot.usermanage.response;

import com.xxlspringboot.usermanage.entity.Ability;
import lombok.Data;

@Data
public class AbilityResponse {
    private long id;
    private String abilityName;
    private double abilityValue;

    public AbilityResponse(Ability ability){
        this.id = ability.getId();
        this.abilityName = ability.getAbilityName();
        this.abilityValue = ability.getAbilityValue();
    }
}
