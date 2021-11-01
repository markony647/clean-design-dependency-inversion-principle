package com.epam.cleandesign.dip.database;

import com.epam.cleandesign.dip.article.AbstractNewsArticle;
import com.epam.cleandesign.dip.article.ArticleType;
import com.epam.cleandesign.dip.article.NationalNewsNewsArticle;
import com.epam.cleandesign.dip.article.RegionalNewsNewsArticle;
import com.epam.cleandesign.dip.dao.NewsArticleDAO;
import com.epam.cleandesign.dip.thirdpartyjar.EntityManager;
import com.epam.cleandesign.dip.thirdpartyjar.NewsArticleTable;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.cleandesign.dip.article.ArticleType.REGIONAL;

public class ArticleDatabaseRepository extends NewsArticleDAO {

    private EntityManager entityManager;

    public ArticleDatabaseRepository() {
        this.entityManager = new EntityManager();
    }

    @Override
    public List<AbstractNewsArticle> findByNewsType(ArticleType articleType) {
        List<NewsArticleTable> foundNews = findNews(articleType);
        return convertAll(foundNews);
    }

    public List<NewsArticleTable> findNews(ArticleType articleType) {
        return entityManager.getAll()
                .stream()
                .filter(article -> articleType.getValue().equals(article.getNewsType()))
                .collect(Collectors.toList());
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    private List<AbstractNewsArticle> convertAll(List<NewsArticleTable> articles) {
        return articles.stream()
                .map(this::convertSingle)
                .collect(Collectors.toList());
    }

    private AbstractNewsArticle convertSingle(NewsArticleTable articleTable) {
        String headline = articleTable.getHeadline();
        String description = articleTable.getDescription();
        if (articleTable.getNewsType().equals(REGIONAL.getValue())) {
            return new RegionalNewsNewsArticle(headline, description);
        }
        return new NationalNewsNewsArticle(headline, description);
    }
}
