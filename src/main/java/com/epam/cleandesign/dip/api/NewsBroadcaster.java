package com.epam.cleandesign.dip.api;

import com.epam.cleandesign.dip.AbstractNewsArticle;
import com.epam.cleandesign.dip.dao.NewsArticleDAO;
import com.epam.cleandesign.dip.publishing.NewsPublisher;
import com.epam.cleandesign.dip.thirdpartyjar.NewsArticleTable;

import java.util.List;

public class NewsBroadcaster {

    private final NewsArticleDAO newsArticleDAO;
    private final NewsPublisher publisher;
    private final AbstractNewsArticle article;

    public NewsBroadcaster(NewsArticleDAO newsArticleDAO, NewsPublisher publisher, AbstractNewsArticle article) {
        this.newsArticleDAO = newsArticleDAO;
        this.publisher = publisher;
        this.article = article;
    }

    public String broadcastNews() {
        List<NewsArticleTable> newsArticles = newsArticleDAO.findByNewsType(article.getType());
        return publisher.publishNews(article, newsArticles);
    }

}
