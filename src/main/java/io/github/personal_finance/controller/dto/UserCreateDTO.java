package io.github.personal_finance.controller.dto;

import java.io.Serializable;

public class UserCreateDTO implements Serializable {

    private String username;

    public UserCreateDTO() {
    }

    public UserCreateDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
