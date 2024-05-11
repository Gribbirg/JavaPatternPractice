package ru.mirea.practice24.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.practice24.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
