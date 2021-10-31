package com.epam.cleandesign.dip.api;

import com.epam.cleandesign.dip.article.AbstractNewsArticle;
import com.epam.cleandesign.dip.article.ArticleType;
import com.epam.cleandesign.dip.dao.NewsArticleDAO;
import com.epam.cleandesign.dip.publishing.NewsPublisher;

import java.util.List;

public class NewsBroadcaster {

    private final NewsArticleDAO newsArticleDAO;
    private final NewsPublisher publisher;
    private final ArticleType articleType;

    public NewsBroadcaster(NewsArticleDAO newsArticleDAO, NewsPublisher publisher, ArticleType articleType) {
        this.newsArticleDAO = newsArticleDAO;
        this.publisher = publisher;
        this.articleType = articleType;
    }

    public String broadcastNews() {
        List<AbstractNewsArticle> newsArticles = newsArticleDAO.findByNewsType(articleType);
        return publisher.publishNews(articleType, newsArticles);
    }

}
