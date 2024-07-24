package com.example.spring_shop.services.inter;

import com.example.spring_shop.response.ResponseData;

public interface IUserService {
    ResponseData getUserById(int id);

    ResponseData getUserByName(String name);

    ResponseData getUsers();

    ResponseData createUser(String name, String password, String dob);

    ResponseData updateUser(int id, String name, String password, String dob);

    ResponseData deleteProduct(int id);
}
