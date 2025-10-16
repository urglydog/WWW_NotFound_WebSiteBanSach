package com.notfound.bookstore.model.dto.request.reviewRequest;

import java.util.UUID;

public class CreateReviewRequest {
    private UUID bookId;
    private Integer rating; // 1-5
    private String comment;
}
