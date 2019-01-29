package io.github.personal_finance.controller.dto;

import io.github.personal_finance.domain.Category;

import java.io.Serializable;

public class ExpenceUpdateInfo implements Serializable {

    private Category category_id;

    public ExpenceUpdateInfo() {
    }

    public ExpenceUpdateInfo(Category category_id) {
        this.category_id = category_id;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }
}
