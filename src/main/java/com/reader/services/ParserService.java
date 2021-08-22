package com.reader.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ParserService {

    public ParserService() {}

    public String getContent(String uri,String nameSource) {
        Document doc;
        try {
            doc = Jsoup.connect(uri).get();
        } catch (IOException e) {
            System.err.println("Error get content URL: " + uri);
            e.printStackTrace();
            return "";
        }
        var selector = _determiningSelectors(nameSource);
        var el = doc.select(selector);
        return _changeImageSize(el);
    }

    //TODO
    private String _determiningSelectors(String nameSource) {
        if (nameSource.equals("habr")) {
            return ".article-formatted-body";
        }
        return "";
    }

    private String _changeImageSize(Elements el) {
        el.get(0).getElementsByTag("img").forEach(it -> {
            it.attributes().remove("width");
            it.attributes().remove("height");
            it.attributes().add("width","100%");
            it.attributes().add("height","100%");
        });
        return el.toString();
    }

}
