package com.notfound.bookstore.model.dto.request.bookRequest;

import java.math.BigDecimal;
import java.time.LocalDate;

// Tạo/cập nhật sách (Admin)
public class CreateBookRequest {
    private String title;
    private String author;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String isbn;
    private String categoryId;
    private String publisher;
    private LocalDate publishDate;
}

