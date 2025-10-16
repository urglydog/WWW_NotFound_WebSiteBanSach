package com.notfound.bookstore.model.dto.response.bookResponse;

import java.util.List;

public class PageResponse<T> {
    private List<T> content;
    private int currentPage;
    private int totalPages;
    private long totalElements;
}