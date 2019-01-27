package io.github.personal_finance.controller.dto;

import io.github.personal_finance.domain.Category;

import java.io.Serializable;

public class ExpenceCreateInfo implements Serializable {

    private Category category_id;

    public ExpenceCreateInfo() {
    }


    public ExpenceCreateInfo(Category category) {
        this.category_id = category;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }
}
