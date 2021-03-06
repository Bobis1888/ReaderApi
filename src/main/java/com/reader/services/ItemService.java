package com.reader.services;

import com.reader.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemService {

    private List<Item> items;
    private SourceService sourceService;
    public ItemService() {
        this.sourceService = new SourceService();
        updateItems();
    }

    public Item findItemById(Long id) {
        var item = items.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
        return sourceService.getItem(item);
    }

    public List<Item> getItems(String nameSource) {
        if (nameSource.equals("all")) {
            return items;
        }
        return items.stream().filter(item -> item.getNameSource().equals(nameSource)).collect(Collectors.toList());
    }

    private void updateItems() {
        if (items == null) {
            items = new ArrayList<>();
        }
        items = sourceService.getItems();
    }

}
