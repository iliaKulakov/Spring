package io.github.personal_finance.controller.dto;

import java.io.Serializable;

public class CategoryUpdateInfo implements Serializable {


    private String name;

    public CategoryUpdateInfo() {
    }

    public CategoryUpdateInfo(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
