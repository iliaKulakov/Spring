package io.github.personal_finance.controller.dto;

import java.io.Serializable;

public class CategoryCreateInfo implements Serializable {

    private String name;

    public CategoryCreateInfo() {
    }

    public CategoryCreateInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
