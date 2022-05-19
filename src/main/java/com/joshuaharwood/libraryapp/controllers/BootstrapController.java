package com.joshuaharwood.libraryapp.controllers;

import com.joshuaharwood.libraryapp.entities.User;
import com.joshuaharwood.libraryapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class BootstrapController {
    final UserRepository userRepository;

    @Autowired
    public BootstrapController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        createDefaultUser();
    }

    private void createDefaultUser() {
        if (!userRepository.existsByUsername("josh")) {
            User s = new User(
                    "josh",
                    "password",
                    "Joshua",
                    "Harwood",
                    LocalDateTime.now(),
                    LocalDate.of(1997, 9, 17),
                    new BigDecimal("10000.00")
            );

            userRepository.save(s);
        }
    }
}
