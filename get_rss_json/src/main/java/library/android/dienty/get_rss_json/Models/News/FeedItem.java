package library.android.dienty.get_rss_json.Models.News;

public class FeedItem {
    private String title;
    private String description;
    private String pubDate;
    private String thumbnail;
    private String link;
    private String name;

    public FeedItem(String title, String description, String pubDate, String thumbnail, String link) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.thumbnail = thumbnail;
        this.link = link;
    }

    private String getTitle() {
        return title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getLink() {
        return link;
    }
}
