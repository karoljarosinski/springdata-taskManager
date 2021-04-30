package com.kj.springdatataskManager;

public enum Status {
    DONE("zrobione"),
    ACTIVE("aktywne");

    private String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
