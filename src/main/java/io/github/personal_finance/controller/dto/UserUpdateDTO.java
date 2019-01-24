package io.github.personal_finance.controller.dto;

import java.io.Serializable;

public class UserUpdateDTO implements Serializable {

    private String username;

    public UserUpdateDTO() {
    }

    public UserUpdateDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
