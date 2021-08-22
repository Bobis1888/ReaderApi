package com.reader.services;

import com.reader.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemService {

    private List<Item> items;

    @Autowired
    private SourceService sourceService;

    public ItemService() {}

    @PostConstruct
    private void init() {
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
        items.forEach(item -> {
            if (item.getNameSource().equals("habr")) {
                var body = item.getBody().replaceAll("<a","<span")
                        .replaceAll("<img","<span");
                item.setBody(body);
            }
        });
    }

}
