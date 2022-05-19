package com.joshuaharwood.libraryapp.repositories;

import com.joshuaharwood.libraryapp.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByUsername(String username);
}
