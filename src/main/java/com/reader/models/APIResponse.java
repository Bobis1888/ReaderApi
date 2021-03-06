package com.reader.models;

import java.util.Arrays;
import java.util.List;

public class APIResponse {

    private User user;
    private List<Item> items;

    public APIResponse() {}

    public APIResponse(User user) {
        this.user = user;
    }

    public APIResponse(List<Item> items) {
        this.items = items;
    }

    public APIResponse(Item ... items) {
        this.items = Arrays.asList(items);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
