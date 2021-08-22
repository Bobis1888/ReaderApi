package com.reader.controllers;

import com.reader.models.Item;
import com.reader.models.User;
import com.reader.repositories.UserRepository;
import com.reader.services.ItemService;
import com.reader.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

    private static final String rootUrl = "/api/";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    public MainController() {}

    @PostMapping(rootUrl + "user/login")
    public ResponseDto login(@RequestBody User user) {
        //MOCK
        var findUser = userRepository.findByEmail(user.getEmail());
        return new ResponseDto(userService.login(findUser));
    }

    @GetMapping(rootUrl + "item/{id}")
    public ResponseDto getItem(@PathVariable Long id) {
        //MOCK
        var item = itemService.findItemById(id);
        return new ResponseDto(item);
    }

    @GetMapping(rootUrl + "items/{nameSource}")
    public ResponseDto getItems(@PathVariable String nameSource) {
        //MOCK
        var it = itemService.getItems(nameSource);
        return new ResponseDto(it);
    }

}

class ResponseDto {

    User user;
    List<Item> items;

    public ResponseDto(Item item) {
        this.items = new ArrayList<>();
        items.add(item);
    }

    public ResponseDto(List<Item> items) {
        this.items = items;
    }

    public ResponseDto(User user) {
        this.user = user;
    }

}
