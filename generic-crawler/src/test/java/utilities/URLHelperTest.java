package utilities;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class URLHelperTest {

    @Test
    public void getInternalLinks() {
        String test_url = "https://tripsget.com/about-us-lizapepe/";
        List<String> links = URLHelper.getInternalLinks(test_url);
        Assert.assertEquals(138, links.size());
    }
}