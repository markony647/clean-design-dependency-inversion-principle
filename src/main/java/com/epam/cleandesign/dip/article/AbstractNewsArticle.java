package com.epam.cleandesign.dip.article;

public abstract class AbstractNewsArticle {

    private final Headline headline;
    private final Description description;

    public AbstractNewsArticle(Headline headline, Description description) {
        this.headline = headline;
        this.description = description;
    }

    public abstract String format();

    public abstract ArticleType getType();

    public String getHeadline() {
        return headline.getHeadline();
    }

    public String getDescription() {
        return description.getDescription();
    }
}
