package library.android.dienty.get_rss_json.Interface;

import io.reactivex.Observable;
import library.android.dienty.get_rss_json.Models.Video.VideoItem;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestInterface {

    @GET("search")
    Observable<VideoItem> register(@Query("part") String part,
                                   @Query("q") String key_search,
                                   @Query("maxResults") String maxResults,
                                   @Query("type") String type,
                                   @Query("key") String key);
}