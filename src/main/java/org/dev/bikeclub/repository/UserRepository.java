package org.dev.bikeclub.repository;

import org.dev.bikeclub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);
    User findFirstByUsername(String username);
}
