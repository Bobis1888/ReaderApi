package com.reader.model;

import java.util.Date;

public class Item {

    private static int count = 0;
    private final int id = ++count;
    private String header;
    private String body;
    private String nameSource;
    private Date publishDate;

    public Item() {}

    public Item(String header, String body, String nameSource, Date publishDate) {
        this.body = body;
        this.header = header;
        this.nameSource = nameSource;
        this.publishDate = publishDate;
    }

    public int getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getNameSource() {
        return nameSource;
    }

    public void setNameSource(String nameSource) {
        this.nameSource = nameSource;
    }

    @Override
    public String toString() {
        return "Item{" +
                "header='" + header + '\'' +
                ", body='" + body + '\'' +
                ", nameSource='" + nameSource + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }

}
