package com.kj.springdatataskManager;

public enum Category {
    HOMEWORK("zadanie domowe"),
    CLEANING("sprzątanie"),
    SHOPPING("zakupy"),
    EXPENSES("wydatki"),
    OTHER("inne");

    private String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
