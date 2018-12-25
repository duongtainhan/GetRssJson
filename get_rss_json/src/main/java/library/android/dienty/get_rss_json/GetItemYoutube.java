package library.android.dienty.get_rss_json;

import android.widget.ListView;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import library.android.dienty.get_rss_json.Interface.RequestInterface;
import library.android.dienty.get_rss_json.Models.Video.Item;
import library.android.dienty.get_rss_json.Models.Video.VideoItem;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetItemYoutube {
    private CompositeDisposable compositeDisposable;
    private VideoItem videoItem;
    private ArrayList<Item> arrayItems;
    private static final String base_url="https://www.googleapis.com/youtube/v3/";

    public void loadJSON(String keyYoutube, String keySearch, int maxResult)
    {
        String numberOfResult = String.valueOf(maxResult);
        compositeDisposable = new CompositeDisposable();
        videoItem = new VideoItem();
        arrayItems = new ArrayList<>();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();
        RequestInterface requestInterface = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(base_url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RequestInterface.class);
        Disposable disposable = requestInterface.register("snippet",keySearch,numberOfResult,"video",keyYoutube)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError, this::handleSuccess);
        compositeDisposable.add(disposable);
    }
    public ArrayList<Item> handleResponse(VideoItem itemVideo) {
        videoItem = itemVideo;
        for(int i=0;i<videoItem.getItems().size();i++)
        {
            Item item = new Item();
            item.setSnippet(videoItem.getItems().get(i).getSnippet());
            item.setId(videoItem.getItems().get(i).getId());
            arrayItems.add(item);
        }
        return arrayItems;
    }
    public String handleError(Throwable error) {

        return "Error " + error.getLocalizedMessage();
    }

    public String handleSuccess() {
        return "successful connection";
    }
}
