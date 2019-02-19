package io.fin_client.dto.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ArrivalCreateInfo implements Serializable {

    private Long categoryId;
    private BigDecimal amount;
    private Long userId;

    public ArrivalCreateInfo() {
    }

    public ArrivalCreateInfo(Long categoryId, BigDecimal amount, Long userId) {
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
