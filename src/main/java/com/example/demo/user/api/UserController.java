package com.example.demo.user.api;

import com.example.demo.user.api.dto.CreateUser;
import com.example.demo.user.api.dto.UpdateUser;
import com.example.demo.user.api.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
class UserController {
    private final UserFacade userFacade;

    UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping
    User createUser(@RequestBody CreateUser createUser) {
        return userFacade.createUser(createUser);
    }

    @RequestMapping("/{userId}")
    @GetMapping
    User getUser(@PathVariable UUID userId){
        return userFacade.getUserById(userId);
    }

    @GetMapping
    List<User> getUsers() {
        return userFacade.getUsers();
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable UUID userId, @RequestBody UpdateUser updateUser) {
        return userFacade.updateUser(userId, updateUser);
    }

    @DeleteMapping("/{userId}")
    long deleteUser(@PathVariable UUID userId) {
        return userFacade.deleteUser(userId);
    }
}
