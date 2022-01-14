package com.epam.cleandesign.dip.dao;

import com.epam.cleandesign.dip.article.AbstractNewsArticle;
import com.epam.cleandesign.dip.article.ArticleType;

import java.util.List;

public abstract class NewsArticleDAOImpl implements NewsArticleDAO {

    @Override
    public abstract List<AbstractNewsArticle> findByNewsType(ArticleType articleType);

}
