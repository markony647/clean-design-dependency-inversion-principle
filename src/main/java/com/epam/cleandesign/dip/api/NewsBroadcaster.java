package com.epam.cleandesign.dip.api;

import com.epam.cleandesign.dip.dao.NewsArticleDAO;
import com.epam.cleandesign.dip.publishing.NewsPublisher;
import com.epam.cleandesign.dip.thirdpartyjar.NewsArticleTable;

import java.util.List;

public class NewsBroadcaster {

    private final NewsArticleDAO newsArticleDAO;
    private final NewsPublisher publisher;

    public NewsBroadcaster(NewsArticleDAO newsArticleDAO, NewsPublisher publisher) {
        this.newsArticleDAO = newsArticleDAO;
        this.publisher = publisher;
    }

    public String broadcastNews(String newsType) {
        List<NewsArticleTable> newsArticles = newsArticleDAO.findByNewsType(newsType);
        return publisher.publishNews(newsType, newsArticles);
    }

}
