package contracts;

import java.util.List;
import java.util.Map;

public interface ICrawlService {
    /**
     * Given a URL crawls a site and prints its sitemap
     *
     * @param url site to crawl
     * @return
     */
    public Map<String, List<String>> crawlSite(String url);
}
