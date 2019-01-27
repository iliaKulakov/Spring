package io.github.personal_finance.controller.dto;

public class CategoryUpdateInfo {


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
