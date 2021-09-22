package com.epam.cleandesign.dip;

import com.epam.cleandesign.dip.api.NewsBroadcaster;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NewsBroadcasterTest {

    private NewsBroadcaster newsBroadcaster;

    @Before
    public void setUp() {
        newsBroadcaster = new NewsBroadcaster();
    }

    @Test
    public void shouldPublishRegionalNews() {
        String regional = newsBroadcaster.broadcastNews("Regional");
        Assert.assertTrue(regional.startsWith("Regional News:"));
        Assert.assertTrue(regional.contains("<"));
        Assert.assertTrue(regional.contains(">"));
    }

    @Test
    public void shouldPublishNationalNews() {
        String national = newsBroadcaster.broadcastNews("National");
        Assert.assertTrue(national.startsWith("National News:"));
        Assert.assertFalse(national.contains("<"));
        Assert.assertFalse(national.contains(">"));
        Assert.assertTrue(national.contains(" -- "));
    }
}