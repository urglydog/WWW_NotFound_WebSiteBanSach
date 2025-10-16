package com.notfound.bookstore.model.dto.response.statisticsResponse;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DailyRevenueResponse {
    private LocalDate date;
    private BigDecimal revenue;
    private Integer orderCount;
}
