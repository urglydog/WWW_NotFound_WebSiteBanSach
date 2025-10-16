package com.notfound.bookstore.model.dto.request.bookRequest;

import java.math.BigDecimal;

// Tìm kiếm & lọc
public class BookSearchRequest {
    private String keyword;
    private String categoryId;
    private String authorId;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private String sortBy;
    private String sortOrder;
    private Integer page;
    private Integer size;
}
