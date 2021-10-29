package com.epam.cleandesign.dip.publishing;

import com.epam.cleandesign.dip.thirdpartyjar.NewsArticleTable;

import java.util.List;

public interface NewsPublisher {

    String publishNews(String newsType, List<NewsArticleTable> newsArticles);
}
