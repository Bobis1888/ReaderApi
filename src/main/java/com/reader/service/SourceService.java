package com.reader.service;

import com.reader.model.Item;
import com.reader.model.UriItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class SourceService {

    private List<String> urlList;
    private List<UriItem> uriItems = new ArrayList<>();

    @Autowired
    private RssService rssService;
    @Autowired
    private ParserService parserService;

    public SourceService() {}

    @PostConstruct
    private void init() {
        _updateUrlList();
    }

    //TODO get url and subUrl in base
    private void _updateUrlList() {
        urlList = List.of("https://habr.com/ru/rss/flows/develop/all/?fl=ru");
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
