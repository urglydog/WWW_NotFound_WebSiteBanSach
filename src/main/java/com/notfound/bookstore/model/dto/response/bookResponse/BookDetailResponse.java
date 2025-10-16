package com.notfound.bookstore.model.dto.response.bookResponse;

import com.notfound.bookstore.model.dto.response.reviewResponse.ReviewResponse;

import java.time.LocalDate;
import java.util.List;

public class BookDetailResponse extends BookResponse {
    private String isbn;
    private String publisher;
    private LocalDate publishDate;
    private List<ReviewResponse> reviews;
    private List<BookResponse> relatedBooks;
}
