package com.epam.cleandesign.dip;

import com.epam.cleandesign.dip.thirdpartyjar.NewsArticleTable;

public abstract class AbstractNewsArticle {
    private String type;

    public abstract String format(NewsArticleTable article);

    protected void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
