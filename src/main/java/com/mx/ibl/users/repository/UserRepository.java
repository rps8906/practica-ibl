package com.mx.ibl.users.repository;

import com.mx.ibl.users.model.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> {
}
