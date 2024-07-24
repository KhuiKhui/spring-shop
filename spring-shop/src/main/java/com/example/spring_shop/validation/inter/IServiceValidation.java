package com.example.spring_shop.validation.inter;

import java.util.Collection;
import java.util.Optional;

public interface IServiceValidation {
    boolean optionalCheck(Optional<?> optional);

    boolean collectionCheck(Collection<?> col);

    <T> boolean notNullCheck(T obj);
}
