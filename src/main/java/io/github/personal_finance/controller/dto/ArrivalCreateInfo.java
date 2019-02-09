package io.github.personal_finance.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ArrivalCreateInfo implements Serializable{

        private Long categoryId;
        private BigDecimal amount;
        private Long userId;

    public ArrivalCreateInfo() {
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
