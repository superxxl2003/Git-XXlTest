package com.xxlspringboot.usermanage.request;

import com.xxlspringboot.usermanage.entity.Ability;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class CreateUserRequest {
    private String name;
    private String username;
    private String email;
    private LocalDateTime createTime;
    private String street;
    private String city;
    private List<CreateAbilityRequest> abilityList;
}
