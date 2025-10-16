package com.notfound.bookstore.model.dto.response.statisticsResponse;

import java.math.BigDecimal;
import java.util.List;

public class RevenueStatisticsResponse {
    private BigDecimal totalRevenue;
    private Integer totalOrders;
    private Integer totalCustomers;
    private List<DailyRevenueResponse> dailyData;
}
