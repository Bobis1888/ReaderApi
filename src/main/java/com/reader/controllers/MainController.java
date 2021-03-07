package com.reader.controllers;

import com.reader.models.APIResponse;
import com.reader.models.User;
import com.reader.repositories.UserRepository;
import com.reader.services.ItemService;
import com.reader.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

    private static final String rootUrl = "/api/";

    private final UserRepository userRepository;
    private final UserService userService;
    private final ItemService itemService;

    public MainController(UserRepository userRepository, UserService userService,ItemService itemService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.itemService = itemService;
    }

    @PostMapping(rootUrl + "user/login")
    public APIResponse login(@RequestBody User user) {
        //MOCK
        var findUser = userRepository.findByEmail(user.getEmail());
        return new APIResponse(userService.login(findUser));
    }

    @GetMapping(rootUrl + "item/{id}")
    public APIResponse getItem(@PathVariable Long id) {
        //MOCK
        var item = itemService.findItemById(id);
        return new APIResponse(item);
    }

    @GetMapping(rootUrl + "items/{nameSource}")
    public APIResponse getItems(@PathVariable String nameSource) {
        //MOCK
        var it = itemService.getItems(nameSource);
        return new APIResponse(it);
    }

}
