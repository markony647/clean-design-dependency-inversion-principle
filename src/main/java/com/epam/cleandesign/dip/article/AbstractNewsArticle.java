package com.epam.cleandesign.dip.article;

public abstract class AbstractNewsArticle {

    private final String headline;
    private final String description;

    public AbstractNewsArticle(String headline, String description) {
        this.headline = headline;
        this.description = description;
    }

    public abstract String format();

    public String getHeadline() {
        return headline;
    }

    public String getDescription() {
        return description;
    }
}
