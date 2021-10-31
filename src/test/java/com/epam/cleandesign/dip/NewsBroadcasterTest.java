package com.epam.cleandesign.dip;

import com.epam.cleandesign.dip.api.NewsBroadcaster;
import com.epam.cleandesign.dip.article.ArticleType;
import com.epam.cleandesign.dip.dao.NewsArticleDAO;
import com.epam.cleandesign.dip.dao.NewsArticleDAOImpl;
import com.epam.cleandesign.dip.publishing.NewsPublisher;
import com.epam.cleandesign.dip.publishing.NewsPublisherService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NewsBroadcasterTest {

    private NewsBroadcaster newsBroadcaster;

    @Before
    public void setUp() {
        NewsArticleDAO dao = new NewsArticleDAOImpl(new ArticleDatabaseRepository());
        NewsPublisher publisher = new NewsPublisherService();
        newsBroadcaster = new NewsBroadcaster(dao, publisher);
    }

    @Test
    public void shouldPublishRegionalNews() {
        String regional = newsBroadcaster.broadcastNews(ArticleType.REGIONAL);
        Assert.assertTrue(regional.startsWith("Regional News:"));
        Assert.assertTrue(regional.contains("<"));
        Assert.assertTrue(regional.contains(">"));
    }

    @Test
    public void shouldPublishNationalNews() {
        String national = newsBroadcaster.broadcastNews(ArticleType.NATIONAL);
        Assert.assertTrue(national.startsWith("National News:"));
        Assert.assertFalse(national.contains("<"));
        Assert.assertFalse(national.contains(">"));
        Assert.assertTrue(national.contains(" -- "));
    }
}