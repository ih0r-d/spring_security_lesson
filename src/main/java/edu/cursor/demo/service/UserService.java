package edu.cursor.demo.service;

import edu.cursor.demo.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long id);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    void deleteByUsername(String username);

    void saveUser(User user);


}
