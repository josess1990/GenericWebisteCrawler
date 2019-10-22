package services;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CrawlServiceTest {

    @Test
    public void crawlSite() {
        CrawlService cs = new CrawlService();
        Map<String, List<String>> siteMap = cs.crawlSite("https://luckytrip.co.uk");
        Assert.assertEquals(20, siteMap.size());
    }
}