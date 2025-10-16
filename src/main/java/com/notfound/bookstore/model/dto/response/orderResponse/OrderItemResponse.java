package com.notfound.bookstore.model.dto.response.orderResponse;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItemResponse {
    private UUID id;
    private String bookTitle;
    private Integer quantity;
    private BigDecimal price;
}