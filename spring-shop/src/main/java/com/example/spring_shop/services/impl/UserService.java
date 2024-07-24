package com.example.spring_shop.services.impl;

import com.example.spring_shop.entities.impl.User;
import com.example.spring_shop.repos.UserRepository;
import com.example.spring_shop.response.ErrorStatus;
import com.example.spring_shop.response.ResponseData;
import com.example.spring_shop.services.inter.IUserService;
import com.example.spring_shop.validation.impl.ServiceValidation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private UserRepository userRepository;
    private ServiceValidation validator;

    public UserService(UserRepository userRepository, ServiceValidation validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    public ResponseData getCurrentUserCred() {
        try {
            String principalName = SecurityContextHolder.getContext().getAuthentication().getName();

            return new ResponseData(principalName, ErrorStatus.GET_METHOD_SUCCESS.getDesc(), ErrorStatus.GET_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.GET_METHOD_FAILED.getDesc(), ErrorStatus.GET_METHOD_FAILED.getCode());
        }
    }

    @Override
    public ResponseData getUserById(int id) {
        try {
            Optional<User> user = userRepository.findById(id);
            validator.optionalCheck(user);
            return new ResponseData(user.toString(), ErrorStatus.GET_METHOD_SUCCESS.getDesc(), ErrorStatus.GET_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.GET_METHOD_FAILED.getDesc(), ErrorStatus.GET_METHOD_FAILED.getCode());
        }
    }

    @Override
    public ResponseData getUserByName(String name) {
        try {
            Optional<User> user = userRepository.findByName(name);
            validator.optionalCheck(user);

            return new ResponseData(user.toString(), ErrorStatus.GET_METHOD_SUCCESS.getDesc(), ErrorStatus.GET_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.GET_METHOD_FAILED.getDesc(), ErrorStatus.GET_METHOD_FAILED.getCode());
        }
    }

    @Override
    public ResponseData getUsers() {
        try {
            List<User> users = userRepository.findByIsActive(true);
            validator.collectionCheck(users);

            return new ResponseData(users.toString(), ErrorStatus.GET_METHOD_SUCCESS.getDesc(), ErrorStatus.GET_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.GET_METHOD_FAILED.getDesc(), ErrorStatus.GET_METHOD_FAILED.getCode());
        }
    }

    @Override
    public ResponseData createUser(String name, String password, String dob) {

        try {
            User user = new User(name, password, dob);
            User saved = userRepository.save(user);
            validator.notNullCheck(saved);

            return new ResponseData(saved.toString(), ErrorStatus.POST_METHOD_SUCCESS.getDesc(), ErrorStatus.POST_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.POST_METHOD_FAILED.getDesc(), ErrorStatus.POST_METHOD_FAILED.getCode());
        }
    }


    @Override
    public ResponseData updateUser(int id, String name, String password, String dob) {

        try {
            User user = userRepository.findById(id).get();
            user.setName(name);
            user.setPassword(password);
            user.setDob(dob);

            User saved = userRepository.save(user);
            validator.notNullCheck(saved);
            return new ResponseData(saved.toString(), ErrorStatus.POST_METHOD_SUCCESS.getDesc(), ErrorStatus.POST_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.POST_METHOD_FAILED.getDesc(), ErrorStatus.POST_METHOD_FAILED.getCode());
        }
    }

    @Override
    public ResponseData deleteProduct(int id) {

        try {
            User user = userRepository.findById(id).get();
            user.setActive(false);
            User saved = userRepository.save(user);
            validator.notNullCheck(saved);
            return new ResponseData(saved.toString(), ErrorStatus.POST_METHOD_SUCCESS.getDesc(), ErrorStatus.POST_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.POST_METHOD_FAILED.getDesc(), ErrorStatus.POST_METHOD_FAILED.getCode());
        }
    }
}
