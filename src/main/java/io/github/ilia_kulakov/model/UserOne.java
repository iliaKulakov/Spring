package io.github.ilia_kulakov.model;

public class UserOne {

    private long id;
    private String content;

    public UserOne(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
