package com.epam.cleandesign.dip.dao;

import com.epam.cleandesign.dip.ArticleDatabaseRepository;
import com.epam.cleandesign.dip.article.*;
import com.epam.cleandesign.dip.thirdpartyjar.NewsArticleTable;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.cleandesign.dip.article.ArticleType.REGIONAL;

public class NewsArticleDAOImpl implements NewsArticleDAO {
    private final ArticleDatabaseRepository articleRepository;

    public NewsArticleDAOImpl(ArticleDatabaseRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<AbstractNewsArticle> findByNewsType(ArticleType articleType) {
        List<NewsArticleTable> foundNews = articleRepository.findByNewsType(articleType);
        return convertAll(foundNews);
    }

    private List<AbstractNewsArticle> convertAll(List<NewsArticleTable> articles) {
        return articles.stream()
                .map(this::convertSingle)
                .collect(Collectors.toList());
    }

    private AbstractNewsArticle convertSingle(NewsArticleTable articleTable) {
        Headline headline = new Headline(articleTable.getHeadline());
        Description description = new Description(articleTable.getDescription());
        if (articleTable.getNewsType().equals(REGIONAL.getValue())) {
            return new RegionalNewsNewsArticle(headline, description);
        }
        return new NationalNewsNewsArticle(headline, description);
    }
}
