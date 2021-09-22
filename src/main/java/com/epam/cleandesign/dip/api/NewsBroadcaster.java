package com.epam.cleandesign.dip.api;

import com.epam.cleandesign.dip.dao.NewsArticleDAO;
import com.epam.cleandesign.dip.thirdpartyjar.NewsArticleTable;
import com.epam.cleandesign.dip.publishing.PublishService;

import java.util.List;

public class NewsBroadcaster {

    private NewsArticleDAO newsArticleDAO = new NewsArticleDAO();;
    private PublishService publishService = new PublishService();

    public String broadcastNews(String newsType) {
        List<NewsArticleTable> newsArticles = newsArticleDAO.findByNewsType(newsType);
        return publishService.publishNews(newsType, newsArticles);
    }

}
