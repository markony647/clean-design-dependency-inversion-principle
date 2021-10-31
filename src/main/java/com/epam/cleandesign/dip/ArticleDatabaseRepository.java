package com.epam.cleandesign.dip;

import com.epam.cleandesign.dip.article.ArticleType;
import com.epam.cleandesign.dip.thirdpartyjar.EntityManager;
import com.epam.cleandesign.dip.thirdpartyjar.NewsArticleTable;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleDatabaseRepository {

    private EntityManager entityManager;

    public ArticleDatabaseRepository() {
        this.entityManager = new EntityManager();
    }

    public List<NewsArticleTable> findByNewsType(ArticleType articleType) {
        return entityManager.getAll()
                .stream()
                .filter(article -> articleType.getValue().equals(article.getNewsType()))
                .collect(Collectors.toList());
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
