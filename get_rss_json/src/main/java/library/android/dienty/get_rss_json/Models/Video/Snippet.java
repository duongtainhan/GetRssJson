package library.android.dienty.get_rss_json.Models.Video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Snippet {

@SerializedName("title")
@Expose
private String title;
@SerializedName("thumbnails")
@Expose
private Thumbnails thumbnails;

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public Thumbnails getThumbnails() {
return thumbnails;
}

public void setThumbnails(Thumbnails thumbnails) {
this.thumbnails = thumbnails;
}

}