package com.notfound.bookstore.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // ==== 4xx: Lỗi phía client ====
    BAD_REQUEST(HttpStatus.BAD_REQUEST, 4000, "Invalid syntax for this request."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, 4010, "User not authenticated."),
    FORBIDDEN(HttpStatus.FORBIDDEN, 4030, "Access denied."),
    NOT_FOUND(HttpStatus.NOT_FOUND, 4040, "Resource not found."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, 4050, "HTTP method not supported."),
    NOT_ACCEPTABLE(HttpStatus.NOT_ACCEPTABLE, 4060, "Invalid Accept header."),
    CONFLICT(HttpStatus.CONFLICT, 4090, "Conflict with current state of resource."),
    GONE(HttpStatus.GONE, 4100, "The requested resource is no longer available."),
    LENGTH_REQUIRED(HttpStatus.LENGTH_REQUIRED, 4110, "Content length required."),
    PRECONDITION_FAILED(HttpStatus.PRECONDITION_FAILED, 4120, "Request precondition failed."),
    PAYLOAD_TOO_LARGE(HttpStatus.PAYLOAD_TOO_LARGE, 4130, "Request entity too large."),
    UNSUPPORTED_MEDIA_TYPE(HttpStatus.UNSUPPORTED_MEDIA_TYPE, 4150, "Media type not supported."),
    UNPROCESSABLE_ENTITY(HttpStatus.UNPROCESSABLE_ENTITY, 4220, "Semantic validation failed."),
    MISSING_ARGUMENTS(HttpStatus.BAD_REQUEST, 4190, "Missing required arguments."),
    INVALID_ARGUMENTS(HttpStatus.BAD_REQUEST, 4200, "Invalid request parameters."),

    // ==== 5xx: Lỗi phía server ====
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 5000, "Unexpected internal server error."),
    NOT_IMPLEMENTED(HttpStatus.NOT_IMPLEMENTED, 5010, "Feature not implemented."),
    BAD_GATEWAY(HttpStatus.BAD_GATEWAY, 5020, "Invalid response from upstream server."),
    SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE, 5030, "Service currently unavailable."),
    GATEWAY_TIMEOUT(HttpStatus.GATEWAY_TIMEOUT, 5040, "Gateway timeout."),
    INITIALIZATION_FAILURE(HttpStatus.INTERNAL_SERVER_ERROR, 5500, "Service initialization failure."),

    // ==== Lỗi xác thực/người dùng (nhánh con của 4xx) ====
    USER_EXISTED(HttpStatus.CONFLICT, 2001, "User already exists."),
    USER_NOT_EXISTED(HttpStatus.NOT_FOUND, 2002, "User not found."),
    BOOK_NOT_FOUND(HttpStatus.NOT_FOUND, 3001, "Book not found."),
    INSUFFICIENT_STOCK(HttpStatus.CONFLICT, 3002, "Insufficient stock available."),
    PAYMENT_FAILED(HttpStatus.PAYMENT_REQUIRED, 4020, "Payment processing failed."),
    USERNAME_INVALID(HttpStatus.BAD_REQUEST, 2003, "Username must be at least 3 characters."),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, 2004, "Password must be at least 8 characters."),
    INVALID_KEY(HttpStatus.BAD_REQUEST, 2005, "Invalid API key."),
    INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED,1002, "Username or password fail"),

    // ==== Lỗi hệ thống không phân loại ====
    UNCATEGORIZED_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, 9999, "Uncategorized error");

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;

    ErrorCode(HttpStatus httpStatus, int code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
