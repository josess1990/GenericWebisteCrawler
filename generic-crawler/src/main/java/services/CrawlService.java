package services;

import contracts.ICrawlService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utilities.URLHelper;

public class CrawlService implements ICrawlService {

    @Override
    public Map<String, List<String>> crawlSite(String url) {
            Map<String, List<String>> crawledSite = new HashMap<>();
        if(URLHelper.validateURL(url)) {
            crawledSite = recursiveCrawl(crawledSite, new ArrayList<String>(), url);
        } else {
            System.out.println("WARN - Invalid input url:" + url);
        }
        return crawledSite;
    }

    private  Map<String, List<String>> recursiveCrawl(Map<String, List<String>> crawled, List<String> visited, String url){
        System.out.println("...");
        List<String> internalLinks = URLHelper.getInternalLinks(url);
        for(String link : internalLinks){
            List<String> crwaledList = crawled.get(url);
            if(crwaledList != null && crawled.get(url).size() > 0){
                crwaledList.add(link);
            } else {
                crwaledList = new ArrayList<>();
                crwaledList.add(link);
            }
            crawled.put(url, crwaledList);
            if (!visited.contains(link)){
                visited.add(link);
                crawled.putAll(recursiveCrawl(crawled, visited, link));
            }
        }
        return crawled;
    }
}
