package com.example.spring_shop.validation.impl;

import com.example.spring_shop.validation.inter.IServiceValidation;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class ServiceValidation implements IServiceValidation {
    @Override
    public boolean optionalCheck(Optional<?> optional) {

        return optional.isPresent();
    }

    public boolean collectionCheck(Collection<?> col) {

        return !col.isEmpty();
    }

    @Override
    public <T> boolean notNullCheck(T obj) {
        return obj == null;
    }

}
