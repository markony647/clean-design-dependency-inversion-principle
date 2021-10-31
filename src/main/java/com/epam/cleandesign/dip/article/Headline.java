package com.epam.cleandesign.dip.article;

public class Headline {
    private final String headline;

    public Headline(String headline) {
        this.headline = headline;
    }

    protected String getHeadline() {
        return headline;
    }
}
