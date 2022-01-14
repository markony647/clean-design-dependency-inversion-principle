package com.epam.cleandesign.dip.publishing;

import com.epam.cleandesign.dip.article.AbstractNewsArticle;
import com.epam.cleandesign.dip.article.ArticleType;

import java.util.List;

public interface NewsPublisher {

    String publishNews(ArticleType articleType, List<AbstractNewsArticle> newsArticles);
}
