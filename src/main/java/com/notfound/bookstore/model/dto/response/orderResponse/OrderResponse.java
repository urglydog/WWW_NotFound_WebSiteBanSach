package com.notfound.bookstore.model.dto.response.orderResponse;

import com.notfound.bookstore.model.dto.response.addressResponse.AddressResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderResponse {
    private UUID id;
    private String orderCode;
    private LocalDateTime orderDate;
    private String status; // "PENDING", "CONFIRMED", "SHIPPING", "COMPLETED"
    private BigDecimal total;
    private List<OrderItemResponse> items;
    private AddressResponse shippingAddress;
}

