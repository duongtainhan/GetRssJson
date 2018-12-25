package library.android.dienty.get_rss_json.Models.News;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TypeItem {
    private String urlRss;
    private String nameType;
    private List<FeedItem> feedItemList = new ArrayList<>();

    public void setUrlType(String urlRss) {
        this.urlRss = urlRss;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getUrlRss() {
        return urlRss;
    }

    public String getNameType() {
        return nameType;
    }
    public List<FeedItem> getAllItems()
    {
        try {
            Document doc = Jsoup.connect(getUrlRss()).get();
            Elements elements = doc.select("item");
            for (Element item : elements) {
                String title = item.select("title").text();
                String link = item.select("link").text();
                String description = item.select("description").text();
                String pubDate = item.select("pubDate").text();
                String imageUrl = "";
                try {
                    imageUrl = item.select("enclosure").get(0).attr("url");
                } catch (Exception ex) {
                }

                String descrizione = Jsoup.parse(description.replaceAll("(?i)<br[^>]*>", "br2n")).text();
                String descriptionMain = descrizione.replaceAll("br2n", "\n");
                if (!imageUrl.isEmpty())
                    feedItemList.add(new FeedItem(title, descriptionMain, pubDate, imageUrl, link));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return feedItemList;
    }
}
