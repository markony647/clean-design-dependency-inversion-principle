package com.epam.cleandesign.dip.article;

import com.epam.cleandesign.dip.thirdpartyjar.NewsArticleTable;

import static com.epam.cleandesign.dip.article.ArticleType.NATIONAL;

public class NationalNewsNewsArticle extends AbstractNewsArticle {


    public NationalNewsNewsArticle(Headline headline, Description description) {
        super(headline, description);
    }

    @Override
    public String format() {
        return getHeadline() + " -- " + getDescription();
    }

    @Override
    public ArticleType getType() {
        return NATIONAL;
    }
}
