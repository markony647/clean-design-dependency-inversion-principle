package com.epam.cleandesign.dip.article;

import static com.epam.cleandesign.dip.article.ArticleType.REGIONAL;

public class RegionalNewsNewsArticle extends AbstractNewsArticle {

    public RegionalNewsNewsArticle(Headline headline, Description description) {
        super(headline, description);
    }

    @Override
    public String format() {
       return "<" + getHeadline() + ">";
    }

    @Override
    public ArticleType getType() {
        return REGIONAL;
    }
}
