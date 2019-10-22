package utilities;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class URLHelper {

    /**
     * Retrieve all internal links contained in a page
     * @param url Page to crawl
     * @return list of internal links
     */
    public static List<String> getInternalLinks(String url) {
        ArrayList<String> inernalLinks = new ArrayList<>();
        try {
            URI uri = new URI(url);
            String baseDomain = uri.getHost();
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                String linkValue = link.attr("abs:href").trim();
                if (linkValue.length() > 0) {
                    URI linkUri = new URI(linkValue);
                    String linkDomain = linkUri.getHost();
                    if (linkDomain != null && linkDomain.equals(baseDomain)) {
                        inernalLinks.add(linkValue);
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("WARNING - Unable to parse URL " + url);
            e.printStackTrace();
        }
        return inernalLinks;
    }

    /**
     * Validate if a String is a valid URL
     * @param url Candidate URL
     * @return True if input string is a valid URL
     */
    public static boolean validateURL(String url){
        try{
            URI uri = new URI(url);
            String baseDomain = uri.getHost();
            if(baseDomain == null || baseDomain.length()<1){
                return false;
            }
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
