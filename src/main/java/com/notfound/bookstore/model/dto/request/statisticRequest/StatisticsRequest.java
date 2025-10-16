package com.notfound.bookstore.model.dto.request.statisticRequest;

import java.time.LocalDate;

public class StatisticsRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private String groupBy;
}