package com.epam.cleandesign.dip;

import com.epam.cleandesign.dip.thirdpartyjar.NewsArticleTable;

public class NationalNewsNewsArticle extends AbstractNewsArticle {

    public NationalNewsNewsArticle() {
        setType("National");
    }

    @Override
    public String format(NewsArticleTable article) {
        return article.getHeadline() + " -- " + article.getDescription();
    }
}
