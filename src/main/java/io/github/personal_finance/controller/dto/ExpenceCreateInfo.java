package io.github.personal_finance.controller.dto;

import java.io.Serializable;

public class ExpenceCreateInfo implements Serializable {

    private long category_id;

    public ExpenceCreateInfo() {
    }

    public ExpenceCreateInfo(long category_id) {
        this.category_id = category_id;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }
}
