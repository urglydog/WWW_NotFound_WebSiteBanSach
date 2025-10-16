package com.notfound.bookstore.model.dto.request.discountRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DiscountCodeRequest {
    private String code;
    private BigDecimal discountPercent;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;
    private Integer maxUses;
}