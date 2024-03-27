package com.mx.ibl.users.controller.error;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserError implements Serializable {

    private String message;
    private Long code;
    private String status;

}
