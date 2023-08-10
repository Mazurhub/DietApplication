package com.example.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
//kontakt z fornt-end'em
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @GetMapping
    @RequestMapping("/{id}")
    public User getUser(@PathVariable UUID id) {
        return service.getUser(id);
    }

    //Definjuje co ma przyjść i co ma zostać wyświetlone. Przy czym używa konkretną metodę z UserService.
    //Postman wysyła tylko request.
    @PostMapping
    public User createUser(@RequestBody CreateUser createUser) {
        return service.createUser(createUser);
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getUsers();
    }

    @DeleteMapping("/{id}")
    public long deleteUser(@PathVariable UUID id) {
        return service.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody UpdateUser updatePerson) {
        return service.updateUser(id, updatePerson);
    }
}
