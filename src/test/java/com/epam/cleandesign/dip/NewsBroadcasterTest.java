package com.epam.cleandesign.dip;

import com.epam.cleandesign.dip.api.NewsBroadcaster;
import com.epam.cleandesign.dip.article.ArticleType;
import com.epam.cleandesign.dip.article.NationalNewsNewsArticle;
import com.epam.cleandesign.dip.article.RegionalNewsNewsArticle;
import com.epam.cleandesign.dip.dao.NewsArticleDAO;
import com.epam.cleandesign.dip.dao.NewsArticleDAOImpl;
import com.epam.cleandesign.dip.publishing.NewsPublisher;
import com.epam.cleandesign.dip.publishing.NewsPublisherService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NewsBroadcasterTest {

    private NewsArticleDAO dao;
    private NewsPublisher publisher;
    private NewsBroadcaster newsBroadcaster;

    @Before
    public void setUp() {
        dao = new NewsArticleDAOImpl(new ArticleDatabaseRepository());
        publisher = new NewsPublisherService();
    }

    @Test
    public void shouldPublishRegionalNews() {
        newsBroadcaster = new NewsBroadcaster(dao, publisher, ArticleType.REGIONAL);
        String regional = newsBroadcaster.broadcastNews();
        Assert.assertTrue(regional.startsWith("Regional News:"));
        Assert.assertTrue(regional.contains("<"));
        Assert.assertTrue(regional.contains(">"));
    }

    @Test
    public void shouldPublishNationalNews() {
        newsBroadcaster = new NewsBroadcaster(dao, publisher, ArticleType.NATIONAL);
        String national = newsBroadcaster.broadcastNews();
        Assert.assertTrue(national.startsWith("National News:"));
        Assert.assertFalse(national.contains("<"));
        Assert.assertFalse(national.contains(">"));
        Assert.assertTrue(national.contains(" -- "));
    }
}