package com.notfound.bookstore.model.dto.response.cartResponse;

import com.notfound.bookstore.model.dto.response.bookResponse.BookResponse;

import java.math.BigDecimal;
import java.util.UUID;

public class CartItemResponse {
    private UUID id;
    private BookResponse book;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subtotal;
}
