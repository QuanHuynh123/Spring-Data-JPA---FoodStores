package com.example.food.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public enum ErrorCode {
    USER_NOT_FOUND(1001, "User not found!", HttpStatus.NOT_FOUND),

    PRODUCT_NOT_FOUND(2001, "Product not found!", HttpStatus.NOT_FOUND),

    UNKNOWN_ERROR(9999, "Unknown error code", HttpStatus.BAD_REQUEST),
    ;

    int code;
    String message;
    HttpStatusCode statusCode;
}
