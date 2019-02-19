package io.github.personal_finance.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExpenceUpdateInfo implements Serializable {

    private Long categoryId;
    private BigDecimal amount;

    public ExpenceUpdateInfo() {
    }

    public ExpenceUpdateInfo(Long categoryId, BigDecimal amount, Long userId) {
        this.categoryId = categoryId;
        this.amount = amount;
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
}
