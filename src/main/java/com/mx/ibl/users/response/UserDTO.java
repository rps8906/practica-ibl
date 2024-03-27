package com.mx.ibl.users.response;

import com.mx.ibl.users.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {

    private Long id;
    private String name;
    private String fullName;
    private String email;
    private String phone;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.fullName = String.format("%s %s %s", user.getLastName(), user.getSecondLastName(), user.getName());
        this.email = user.getEmail();
        this.phone = user.getPhone();
    }
}