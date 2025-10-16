package com.notfound.bookstore.model.dto.response.statisticsResponse;

import com.notfound.bookstore.model.dto.response.bookResponse.BookResponse;

import java.math.BigDecimal;

public class TopSellingBookResponse {
    private BookResponse book;
    private Integer totalSold;
    private BigDecimal totalRevenue;
}