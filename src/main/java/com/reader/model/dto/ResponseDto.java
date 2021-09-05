package com.reader.model.dto;

import com.reader.model.Item;
import com.reader.model.User;

import java.util.ArrayList;
import java.util.List;

public class ResponseDto {

    User user;
    List<Item> items;

    public ResponseDto(Item item) {
        this.items = new ArrayList<>();
        items.add(item);
    }

    public ResponseDto(List<Item> items) {
        this.items = items;
    }

    public ResponseDto(Item... items) {
        this.items = List.of(items);
    }

    public ResponseDto(User user) {
        this.user = user;
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
