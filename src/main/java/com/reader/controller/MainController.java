package com.reader.controller;

import com.reader.model.User;
import com.reader.model.dto.ResponseDto;
import com.reader.repos.UserRepository;
import com.reader.service.ItemService;
import com.reader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
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

