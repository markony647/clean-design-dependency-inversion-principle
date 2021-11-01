package com.epam.cleandesign.dip.article;

public class RegionalNewsNewsArticle extends AbstractNewsArticle {

    public RegionalNewsNewsArticle(String headline, String description) {
        super(headline, description);
    }

    @Override
    public String format() {
       return "<" + getHeadline() + ">";
    }
}
