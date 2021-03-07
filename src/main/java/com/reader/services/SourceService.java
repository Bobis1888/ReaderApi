package com.reader.services;

import com.reader.models.Item;
import com.reader.models.UriItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SourceService {

    private List<String> urlList;
    private List<UriItem> uriItems;

    private RssService rssService;
    private ParserService parserService;

    public SourceService(RssService rssService,ParserService parserService) {
        _updateUrlList();
        this.uriItems = new ArrayList<>();
        this.rssService = rssService;
        this.parserService = parserService;
    }

    //TODO get url and subUrl in base
    private void _updateUrlList() {
        urlList = Arrays.asList("https://habr.com/ru/rss/flows/develop/all/?fl=ru");
    }

    public List<Item> getItems() {
        var result = new ArrayList<Item>();
        urlList.forEach(url -> {
            List[] itemsAndUrl = rssService.getItems(url);
            result.addAll(itemsAndUrl[0]);
            uriItems.clear();
            uriItems.addAll(itemsAndUrl[1]);
        });
        return result;
    }

    public Item getItem(Item item) {
        var uri = uriItems.stream().filter(uriItem -> uriItem.getId() == item.getId()).findFirst().orElse(null);
        return new Item(
                item.getHeader(),
                parserService.getContent(uri.getUrl(),item.getNameSource()),
                item.getNameSource(),
                item.getPublishDate());
    }

}
