package com.epam.cleandesign.dip.article;

public class RegionalNewsNewsArticle extends AbstractNewsArticle {

    public RegionalNewsNewsArticle(Headline headline, Description description) {
        super(headline, description);
    }

    @Override
    public String format() {
       return "<" + getHeadline() + ">";
    }
}
