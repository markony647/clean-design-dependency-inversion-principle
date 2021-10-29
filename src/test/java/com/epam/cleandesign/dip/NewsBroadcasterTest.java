package com.epam.cleandesign.dip;

import com.epam.cleandesign.dip.api.NewsBroadcaster;
import com.epam.cleandesign.dip.dao.NewsArticleDAO;
import com.epam.cleandesign.dip.dao.NewsArticleDAOImpl;
import com.epam.cleandesign.dip.publishing.NewsPublisher;
import com.epam.cleandesign.dip.publishing.PublishService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NewsBroadcasterTest {

    private NewsArticleDAO dao;
    private NewsPublisher publisher;
    private NewsBroadcaster newsBroadcaster;

    @Before
    public void setUp() {
        dao = new NewsArticleDAOImpl();
        publisher = new PublishService();
    }

    @Test
    public void shouldPublishRegionalNews() {
        newsBroadcaster = new NewsBroadcaster(dao, publisher, new RegionalNewsNewsArticle());
        String regional = newsBroadcaster.broadcastNews();
        Assert.assertTrue(regional.startsWith("Regional News:"));
        Assert.assertTrue(regional.contains("<"));
        Assert.assertTrue(regional.contains(">"));
    }

    @Test
    public void shouldPublishNationalNews() {
        newsBroadcaster = new NewsBroadcaster(dao, publisher, new NationalNewsNewsArticle());
        String national = newsBroadcaster.broadcastNews();
        Assert.assertTrue(national.startsWith("National News:"));
        Assert.assertFalse(national.contains("<"));
        Assert.assertFalse(national.contains(">"));
        Assert.assertTrue(national.contains(" -- "));
    }
}