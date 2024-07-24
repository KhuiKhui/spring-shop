package com.example.spring_shop.services.inter;

import com.example.spring_shop.response.ResponseData;

public interface IProductService {
    ResponseData getProductById(int id);

    ResponseData getProducts();

    ResponseData createProduct(String name, double price);

    ResponseData updateProduct(int id, String name, double price);

    ResponseData deleteProduct(int id);
}
