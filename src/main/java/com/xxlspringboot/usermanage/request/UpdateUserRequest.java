package com.xxlspringboot.usermanage.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserRequest {
    private long id;
    private String name;
    private String username;
    private String email;
    private String street;
    private String city;
}
