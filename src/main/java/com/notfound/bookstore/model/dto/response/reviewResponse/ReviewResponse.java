package com.notfound.bookstore.model.dto.response.reviewResponse;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReviewResponse {
    private UUID id;
    private String username;
    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;
    private Boolean isVerifiedPurchase;
}
