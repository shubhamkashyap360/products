package com.productservice.products.controllers;

import com.productservice.products.dtos.ProductRequestDtoFS;
import com.productservice.products.dtos.ProductResponseSelf;
import com.productservice.products.exceptions.ProductNotFoundException;
import com.productservice.products.models.Category;
import com.productservice.products.models.Product;

import com.productservice.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Qualifier("fakestoreProductService")
    @Autowired
    IProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

//    @GetMapping("/products/{id}")
//    public ResponseEntity<ProductResponseSelf> getSingleProduct(@PathVariable("id") Long id){
//        Product product;
//        try {
//            product = productService.getSingleProduct(id);
//        }catch (ProductNotFoundException e){
//            ProductResponseSelf productResponseSelf = new ProductResponseSelf(null, "Product Does not exists ");
//            return new ResponseEntity<>(productDoesNotExists,HttpStatus.NOT_FOUND);
//        }catch (ArithmeticException e){
//            ProductResponseSelf productDoesNotExists = new ProductResponseSelf(null, "Something went wrong");
//            return new ResponseEntity<>(productDoesNotExists,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>(new ProductResponseSelf(product, "Success "), HttpStatus.OK);
//    }
@GetMapping("/product/exception/{id}")
public ResponseEntity<ProductResponseSelf> getSingleProductException(@PathVariable("id") Long id)
        throws ProductNotFoundException {

    Product product;
    product = productService.getSingleProduct(id);

    return new ResponseEntity<>(new ProductResponseSelf(product, "Success "), HttpStatus.OK);
}




    @GetMapping("/products/categories")
    public List<Category> getAllCategories(){
        return new ArrayList<>();
    }

    @GetMapping("/products/categories/{id}")
    public List<Product> getAllProductsInCategory(@PathVariable("id") Long id){
        return new ArrayList<>();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDtoFS requestDto){
        return new Product();
    }

    @PatchMapping ("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody ProductRequestDtoFS requestDto){
        return new Product();
    }

    @DeleteMapping ("/products/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id){
        return true;
    }


}
