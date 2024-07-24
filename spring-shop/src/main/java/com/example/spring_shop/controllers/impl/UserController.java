package com.example.spring_shop.controllers.impl;

import com.example.spring_shop.controllers.inter.IUserController;
import com.example.spring_shop.entities.impl.User;
import com.example.spring_shop.repos.UserRepository;
import com.example.spring_shop.response.ErrorStatus;
import com.example.spring_shop.response.ResponseData;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController implements IUserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @GetMapping("")
    public ResponseData getUsers() {
        try {
            return new ResponseData(userRepository.findAll().toString(), ErrorStatus.GET_METHOD_SUCCESS.getDesc(), ErrorStatus.GET_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.GET_METHOD_FAILED.getDesc(), ErrorStatus.GET_METHOD_FAILED.getCode());
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseData getUserById(@PathVariable Integer id) {
        try {
            Optional<User> user = userRepository.findById(id);
            return new ResponseData(user.toString(), ErrorStatus.GET_METHOD_SUCCESS.getDesc(), ErrorStatus.GET_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.GET_METHOD_FAILED.getDesc(), ErrorStatus.GET_METHOD_FAILED.getCode());
        }
    }

    @Override
    @PostMapping("")
    public ResponseData createUser(@RequestBody User user) {
        try {
            userRepository.save(user);

            return new ResponseData("1", ErrorStatus.POST_METHOD_SUCCESS.getDesc(), ErrorStatus.POST_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.POST_METHOD_FAILED.getDesc(), ErrorStatus.POST_METHOD_FAILED.getCode());
        }
    }


    @Override
    @PutMapping("/{id}")
    public ResponseData updateUser(@RequestBody User user, @PathVariable int id) {
        try {
            user.setId(id);
            userRepository.save(user);

            return new ResponseData("1", ErrorStatus.POST_METHOD_SUCCESS.getDesc(), ErrorStatus.POST_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.POST_METHOD_FAILED.getDesc(), ErrorStatus.POST_METHOD_FAILED.getCode());
        }
    }

    @Override
    @PutMapping("/{id}/delete")
    public void deleteUser(@PathVariable int id) {
        userRepository.findById(id).stream().toList().get(0).setActive(false);
        userRepository.deleteById(id);
    }
}
