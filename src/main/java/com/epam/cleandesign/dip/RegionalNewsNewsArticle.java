package com.epam.cleandesign.dip;

import com.epam.cleandesign.dip.thirdpartyjar.NewsArticleTable;

public class RegionalNewsNewsArticle extends AbstractNewsArticle {

    public RegionalNewsNewsArticle() {
        setType("Regional");
    }

    @Override
    public String format(NewsArticleTable article) {
       return "<" + article.getHeadline() + ">";
    }
}
