package com.mx.ibl.users.model;

import com.mx.ibl.users.response.UserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    private String secondLastName;
    @NotNull
    private String email;
    @NotNull
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;

    public User(UserDTO userDTO){
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.lastName = userDTO.getFullName().split(" ")[1];
        this.secondLastName = userDTO.getFullName().split(" ")[2];
        this.email = userDTO.getEmail();
        this.phone = userDTO.getPhone();
    }
}
