package com.example.demo.user.api;

import com.example.demo.user.api.dto.CreateUser;
import com.example.demo.user.api.dto.UpdateUser;
import com.example.demo.user.api.dto.User;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserFacade userFacade;

    UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping
    User createUser(@RequestBody CreateUser createUser) {
        return userFacade.createUser(createUser);
    }

    @RequestMapping("/{id}")
    @GetMapping
    User getUser(@PathVariable UUID id){
        return userFacade.getUserById(id);
    }

    @GetMapping
    List<User> getUsers() {
        return userFacade.getUsers();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody UpdateUser updateUser) {
        return userFacade.updateUser(id, updateUser);
    }

    @DeleteMapping("/{id}")
    public long deleteUser(@PathVariable UUID id) {
        return userFacade.deleteUser(id);
    }
}
