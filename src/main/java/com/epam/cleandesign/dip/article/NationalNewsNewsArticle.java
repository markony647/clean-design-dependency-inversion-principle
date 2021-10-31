package com.epam.cleandesign.dip.article;

public class NationalNewsNewsArticle extends AbstractNewsArticle {

    public NationalNewsNewsArticle(Headline headline, Description description) {
        super(headline, description);
    }

    @Override
    public String format() {
        return getHeadline() + " -- " + getDescription();
    }
}
