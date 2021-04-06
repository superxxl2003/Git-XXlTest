package com.xxlspringboot.usermanage.response;

import com.xxlspringboot.usermanage.entity.Ability;
import com.xxlspringboot.usermanage.entity.User;
import com.xxlspringboot.usermanage.repository.UserRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class UserResponse {

    private long id;
    private String name;
    private String username;
    private String email;
    private LocalDateTime createTime;
    private String street;
    private String city;
    private List<AbilityResponse> abilities;

    public UserResponse(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.createTime = user.getCreateTime();

        this.street = user.getAddress().getStreet();
        this.city = user.getAddress().getCity();

        if (user.getAbilities() != null) {
            abilities = new ArrayList<AbilityResponse>();
            for (Ability ability: user.getAbilities()) {
                abilities.add(new AbilityResponse(ability));
            }
        }
    }

}
