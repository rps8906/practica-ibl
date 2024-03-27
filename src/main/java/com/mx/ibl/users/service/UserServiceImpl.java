package com.mx.ibl.users.service;

import com.mx.ibl.users.model.User;
import com.mx.ibl.users.repository.UserRepository;
import com.mx.ibl.users.response.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;
    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = userRepository.findAll().stream()
                .filter(user -> user.getDeletedAt() == null)
                .map(user -> new UserDTO(user)).collect(Collectors.toList());
        return users;
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user.getDeletedAt() != null){
            new UserDTO(user);
        }
        return null;
    }

    @Override
    public Long createUser(UserDTO user) {
        User entity = new User(user);
        entity.setCreatedAt(LocalDateTime.now());
        entity = userRepository.save(entity);
        return entity.getId();
    }

    @Override
    public String updateUser(UserDTO user) {
        User entity = userRepository.findById(user.getId()).orElse(null);
        if(entity == null){
            throw new RuntimeException("No se encontró el usuario");
        }
        entity = new User(user);
        userRepository.save(entity);
        return "usuario con id: " +entity.getId()+ " actualizado ";
    }

    @Override
    public String deleteUser(Long id) {
        User entity = userRepository.findById(id).orElse(null);
        if(entity == null){
            throw new RuntimeException("No se encontró el usuario");
        }
        entity.setDeletedAt(LocalDateTime.now());
        userRepository.save(entity);
        return "usuario con id: " +entity.getId()+ " eliminado ";
    }
}