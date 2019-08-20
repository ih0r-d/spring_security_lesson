package edu.cursor.demo.controller;

import edu.cursor.demo.model.User;
import edu.cursor.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/employees")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<User> findAllUsers(@PathVariable Long id) {
        User user = userService.getUserById(id).get();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }
}
