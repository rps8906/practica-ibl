package com.mx.ibl.users.controller.error;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserNotFundException extends RuntimeException {
    public UserNotFundException(String message) {

    }
}
