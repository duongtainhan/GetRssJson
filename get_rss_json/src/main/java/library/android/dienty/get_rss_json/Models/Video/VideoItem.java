package library.android.dienty.get_rss_json.Models.Video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoItem {

@SerializedName("items")
@Expose
private List<Item> items = null;

public List<Item> getItems() {
return items;
}

public void setItems(List<Item> items) {
this.items = items;
}

}