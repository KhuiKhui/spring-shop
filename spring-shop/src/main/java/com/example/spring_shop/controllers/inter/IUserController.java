package com.example.spring_shop.controllers.inter;

import com.example.spring_shop.entities.impl.User;
import com.example.spring_shop.response.ResponseData;
import org.springframework.web.bind.annotation.*;

public interface IUserController {
    @GetMapping("")
    ResponseData getUsers();

    @GetMapping("/{id}")
    ResponseData getUserById(@PathVariable Integer id);

    @PostMapping("")
    ResponseData createUser(@RequestBody User user);

    @PutMapping("/{id}")
    ResponseData updateUser(@RequestBody User user, @PathVariable int id);

    @PutMapping("/{id}/delete")
    void deleteUser(@PathVariable int id);
}
