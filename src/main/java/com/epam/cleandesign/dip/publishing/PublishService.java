package com.epam.cleandesign.dip.publishing;

import com.epam.cleandesign.dip.AbstractNewsArticle;
import com.epam.cleandesign.dip.thirdpartyjar.NewsArticleTable;

import java.util.List;
import java.util.stream.Collectors;

public class PublishService implements NewsPublisher {

    @Override
    public String publishNews(AbstractNewsArticle article, List<NewsArticleTable> newsArticles) {
        return article.getType() + " News:\n" + newsArticles.stream()
                .map(article::format)
                .collect(Collectors.joining("\n"));
    }
}
