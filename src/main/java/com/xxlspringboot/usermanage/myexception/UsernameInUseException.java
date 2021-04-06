package com.xxlspringboot.usermanage.myexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.IM_USED)
public class UsernameInUseException extends RuntimeException {
    public UsernameInUseException(String message) {
        super(message);
    }

    public UsernameInUseException() {
    }
}
