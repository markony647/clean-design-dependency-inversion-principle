package com.epam.cleandesign.dip.article;

public enum ArticleType {
    NATIONAL("National"),
    REGIONAL("Regional");

    private final String type;

    ArticleType(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }
}
