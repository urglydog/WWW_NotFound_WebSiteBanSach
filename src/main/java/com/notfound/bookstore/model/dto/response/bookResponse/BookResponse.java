package com.notfound.bookstore.model.dto.response.bookResponse;

import java.math.BigDecimal;
import java.util.UUID;

public class BookResponse {
    private UUID id;
    private String title;
    private String author;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String imageUrl;
    private Double avgRating;
    private Integer totalReviews;
    private String categoryName;
}
