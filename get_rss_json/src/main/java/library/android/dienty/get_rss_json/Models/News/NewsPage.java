package library.android.dienty.get_rss_json.Models.News;

import java.util.ArrayList;
import java.util.List;

public class NewsPage {
    List<TypeItem> allTypeOfPage = new ArrayList<>();

    public void addType(String urlRssOfType, String nameOfType)
    {
        TypeItem typeItem = new TypeItem();
        typeItem.setUrlType(urlRssOfType);
        typeItem.setNameType(nameOfType);
        allTypeOfPage.add(typeItem);
    }
    public String getNameTypeAt(int index)
    {
        return allTypeOfPage.get(index).getNameType();
    }
    public String getUrlTypeAt(int index)
    {
        return allTypeOfPage.get(index).getUrlRss();
    }
    public Integer getNumberTypeOfPage()
    {
        return allTypeOfPage.size();
    }

    public List<FeedItem> getAllItemAt(int indexOfType)
    {
        return allTypeOfPage.get(indexOfType).getAllItems();
    }
    public List<FeedItem> getAllItemAt(String nameOfType)
    {
        int atType = -1;
        for(int i=0; i<allTypeOfPage.size(); i++)
        {
            if(nameOfType.equals(allTypeOfPage.get(i).getNameType()))
            {
                atType = i;
            }
        }
        if(atType==-1)
        {
            return null;
        }
        else
        {
            return allTypeOfPage.get(atType).getAllItems();
        }
    }

}