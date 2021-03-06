package com.reader.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ParserService {

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
        return el.toString();
    }

    //TODO
    private String _determiningSelectors(String nameSource) {
        if (nameSource.equals("habr")) {
            return ".post__wrapper";
        }
        return "";
    }

}
