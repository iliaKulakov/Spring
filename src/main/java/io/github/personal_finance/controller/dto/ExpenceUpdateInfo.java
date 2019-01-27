package io.github.personal_finance.controller.dto;

public class ExpenceUpdateInfo {

    private long category_id;

    public ExpenceUpdateInfo() {
    }

    public ExpenceUpdateInfo(long category_id) {
        this.category_id = category_id;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }
}
