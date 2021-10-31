package com.epam.cleandesign.dip.article;

public class Description {
    private final String description;

    public Description(String description) {
        this.description = description;
    }

    protected String getDescription() {
        return description;
    }
}
