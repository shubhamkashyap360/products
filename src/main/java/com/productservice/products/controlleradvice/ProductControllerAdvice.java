package com.productservice.products.controlleradvice;


import com.productservice.products.dtos.ProductResponseSelf;
import com.productservice.products.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductResponseSelf> handleInvalidProduct(){
        ProductResponseSelf productResponseSelf = new ProductResponseSelf(null, "Product Does not exists from Controller Advice ");
        return new ResponseEntity<>(productResponseSelf, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ProductResponseSelf> handleArithmeticException (){
        ProductResponseSelf productResponseSelf = new ProductResponseSelf(
                null, "Something went wrong from controller advice");
        return new ResponseEntity<>(productResponseSelf,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
