import org.json.JSONObject;
import services.CrawlService;

import java.util.List;
import java.util.Map;

public class Runner {

    public static void main (String[] args){
        CrawlService service = new CrawlService();
        Map<String, List<String> > siteMap = service.crawlSite(args[0]);
        System.out.println(new JSONObject(siteMap).toString(2));
    }
}
