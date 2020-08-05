package com.example.banzinga.resources;

import com.example.banzinga.domain.User;
import com.example.banzinga.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
//        User maria = new User("1", "Matia Silva", "maria@gmail.com");
//        User alex = new User("2", "Alex Silva", "alex@gmail.com");

        List<User> list = service.findAll();
//        list.addAll(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(list);
    }
}