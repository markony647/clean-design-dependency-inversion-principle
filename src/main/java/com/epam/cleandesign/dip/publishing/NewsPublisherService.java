package com.epam.cleandesign.dip.publishing;

import com.epam.cleandesign.dip.article.AbstractNewsArticle;
import com.epam.cleandesign.dip.article.ArticleType;

import java.util.List;
import java.util.stream.Collectors;

public class NewsPublisherService implements NewsPublisher {

    @Override
    public String publishNews(ArticleType articleType, List<AbstractNewsArticle> newsArticles) {
        return articleType.getValue() + " News:\n" + newsArticles.stream()
                .map(AbstractNewsArticle::format)
                .collect(Collectors.joining("\n"));
    }
}
