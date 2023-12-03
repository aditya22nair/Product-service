package com.example.ProductService.customExceptions;

public class ProductUpdateException extends RuntimeException  {
    public ProductUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
