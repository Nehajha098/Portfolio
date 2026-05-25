package com.portfolio.neha.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Sender {

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String message;

    public Sender() {}

    public Sender(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}