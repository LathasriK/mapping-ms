package com.user.mappingservice.controller;

import com.user.mappingservice.model.Response;
import com.user.mappingservice.model.User;
import com.user.mappingservice.model.Users;
import com.user.mappingservice.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class Controller {
    @Autowired
    private MapService mapService;

    @PostMapping
    public ResponseEntity<Response> getUser(@RequestBody User user) throws IOException {
        Response details = mapService.getUser(user);
        return new ResponseEntity<>(details, HttpStatus.OK);

    }
}
