package com.reader.service;

import com.reader.model.Item;
import com.reader.model.UriItem;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class RssService {

    public RssService() {}

    public List[] getItems(String url) {
        List[] result = new ArrayList[2];
        var listItem = new ArrayList<Item>();
        var listUrl = new ArrayList<UriItem>();
        var input = new SyndFeedInput();
        try {
            var uri = new URL(url);
            input.build(new XmlReader(uri)).getEntries().forEach(syndEntry -> {
                var item = _convert(syndEntry);
                listItem.add(item);
                listUrl.add(new UriItem(item.getId(), syndEntry.getUri()));
            });
        } catch (FeedException | IOException e) {
            e.printStackTrace();
        }
        result[0] = listItem;
        result[1] = listUrl;
        return result;
    }
    //TODO
    private Item _convert(SyndEntry feed) {
        return new Item(
                feed.getTitle(),
                feed.getDescription().getValue(),
                "habr",
                feed.getPublishedDate()
        );
    }
}
