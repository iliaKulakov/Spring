package io.github.personal_finance.controller.dto;

import java.math.BigDecimal;

public class ArrivalUpdateInfo {

    private Long categoryId;
    private BigDecimal amount;
    private Long userId;

    public ArrivalUpdateInfo() {
    }

    public ArrivalUpdateInfo(Long categoryId, BigDecimal amount, Long userId) {
        this.categoryId = categoryId;
        this.amount = amount;
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
