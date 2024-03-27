package com.mx.ibl.users.controller;

import com.mx.ibl.users.response.UserDTO;
import com.mx.ibl.users.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAlUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody UserDTO user){
        userService.createUser(user);
        return null;
    }

    @PutMapping
    public String updateUser(@RequestBody UserDTO user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }
}