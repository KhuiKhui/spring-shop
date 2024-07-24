package com.example.spring_shop.services.impl;

import com.example.spring_shop.controllers.impl.ProductController;
import com.example.spring_shop.entities.impl.Product;
import com.example.spring_shop.repos.ProductRepository;
import com.example.spring_shop.response.ErrorStatus;
import com.example.spring_shop.response.ResponseData;
import com.example.spring_shop.services.inter.IProductService;
import com.example.spring_shop.validation.impl.ServiceValidation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ProductService implements IProductService {
    private final Logger logger = Logger.getLogger(ProductController.class.getName());
    private ProductRepository productRepository;
    private ServiceValidation validator;

    public ProductService(ProductRepository productRepository, ServiceValidation validator) {
        this.productRepository = productRepository;
        this.validator = validator;
    }

    public ResponseData getProductById(int id) {
        try {
            Optional<Product> product = productRepository.findById(id);
            validator.optionalCheck(product);
            return new ResponseData(product.get().toString(), ErrorStatus.GET_METHOD_SUCCESS.getDesc(), ErrorStatus.GET_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.GET_METHOD_FAILED.getDesc(), ErrorStatus.GET_METHOD_FAILED.getCode());
        }
    }

    public ResponseData getProducts() {
        try {
            List<Product> products = productRepository.findByIsActive(true);
            validator.collectionCheck(products);

            return new ResponseData(products.toString(), ErrorStatus.GET_METHOD_SUCCESS.getDesc(), ErrorStatus.GET_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.GET_METHOD_FAILED.getDesc(), ErrorStatus.GET_METHOD_FAILED.getCode());
        }
    }

    public ResponseData createProduct(String name, double price) {

        try {
            Product product = new Product(name, price);
            Product saved = productRepository.save(product);
            validator.notNullCheck(saved);
            return new ResponseData(product.toString(), ErrorStatus.POST_METHOD_SUCCESS.getDesc(), ErrorStatus.POST_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.POST_METHOD_FAILED.getDesc(), ErrorStatus.POST_METHOD_FAILED.getCode());
        }
    }

    public ResponseData createBulkProducts(List<Product> products) {

        try {
            List<Product> bulk = productRepository.saveAll(products);
            validator.collectionCheck(bulk);
            return new ResponseData(bulk.toString(), ErrorStatus.POST_METHOD_SUCCESS.getDesc(), ErrorStatus.POST_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.POST_METHOD_FAILED.getDesc(), ErrorStatus.POST_METHOD_FAILED.getCode());
        }
    }


    public ResponseData updateProduct(int id, String name, double price) {

        try {
            Product product = productRepository.findById(id).get();
            product.setName(name);
            product.setPrice(price);

            Product saved = productRepository.save(product);
            validator.notNullCheck(saved);

            return new ResponseData(product.toString(), ErrorStatus.POST_METHOD_SUCCESS.getDesc(), ErrorStatus.POST_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.POST_METHOD_FAILED.getDesc(), ErrorStatus.POST_METHOD_FAILED.getCode());
        }
    }

    public ResponseData deleteProduct(int id) {

        try {
            Product product = productRepository.findById(id).get();
            product.setActive(false);
            Product saved = productRepository.save(product);
            validator.notNullCheck(saved);
            logger.info("PASSED CHECKS");

            return new ResponseData(saved.toString(), ErrorStatus.POST_METHOD_SUCCESS.getDesc(), ErrorStatus.POST_METHOD_SUCCESS.getCode());
        } catch (Exception e) {
            return new ResponseData(null, ErrorStatus.POST_METHOD_FAILED.getDesc(), ErrorStatus.POST_METHOD_FAILED.getCode());
        }
    }
}
