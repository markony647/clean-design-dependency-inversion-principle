package com.epam.cleandesign.dip.dao;

import com.epam.cleandesign.dip.thirdpartyjar.EntityManager;
import com.epam.cleandesign.dip.thirdpartyjar.NewsArticleTable;

import java.util.List;
import java.util.stream.Collectors;

public class NewsArticleDAO {
    private EntityManager entityManager;

    public NewsArticleDAO() {
        this.entityManager = new EntityManager();
    }

    public List<NewsArticleTable> findByNewsType(String newsType) {
        return entityManager.getAll()
                .stream()
                .filter(article -> newsType.equals(article.getNewsType()))
                .collect(Collectors.toList());
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
