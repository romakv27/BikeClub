package org.dev.bikeclub.service;

import org.dev.bikeclub.dto.RegistrationDto;
import org.dev.bikeclub.model.User;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    User findByEmail(String email);
    User findByUsername(String username);
}
