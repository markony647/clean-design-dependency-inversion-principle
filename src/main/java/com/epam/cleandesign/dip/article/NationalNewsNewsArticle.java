package com.epam.cleandesign.dip.article;

public class NationalNewsNewsArticle extends AbstractNewsArticle {

    public NationalNewsNewsArticle(String headline, String description) {
        super(headline, description);
    }

    @Override
    public String format() {
        return getHeadline() + " -- " + getDescription();
    }
}
