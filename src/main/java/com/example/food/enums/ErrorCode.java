package com.example.food.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public enum ErrorCode {
    CUSTOMER_NOT_FOUND(1001, "Customer not found!", HttpStatus.NOT_FOUND),
    CUSTOMER_ALREADY_EXISTED(1002, "Customer already existed!", HttpStatus.CONFLICT),

    PRODUCT_NOT_FOUND(2001, "Product not found!", HttpStatus.NOT_FOUND),

    SUPPLIER_NOT_FOUND(3001, "Supplier not found!", HttpStatus.NOT_FOUND),

    ORDER_NOT_FOUND(4001, "Order not found!", HttpStatus.NOT_FOUND),

    ORDER_ITEM_NOT_FOUND(5001, "Order item not found!", HttpStatus.NOT_FOUND),

    UNKNOWN_ERROR(9999, "Unknown error code", HttpStatus.BAD_REQUEST),
    ;

    int code;
    String message;
    HttpStatusCode statusCode;
}
