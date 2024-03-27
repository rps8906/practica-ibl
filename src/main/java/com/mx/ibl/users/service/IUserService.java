package com.mx.ibl.users.service;

import com.mx.ibl.users.response.UserDTO;

import java.util.List;

public interface IUserService {

    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    Long createUser(UserDTO user);

    String updateUser(UserDTO user);
    String deleteUser(Long id);
}
