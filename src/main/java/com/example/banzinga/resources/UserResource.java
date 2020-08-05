package com.example.banzinga.resources;

import com.example.banzinga.domain.User;
import com.example.banzinga.dto.UserDTO;
import com.example.banzinga.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
//        User maria = new User("1", "Matia Silva", "maria@gmail.com");
//        User alex = new User("2", "Alex Silva", "alex@gmail.com");

        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
//        list.addAll(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {

        User obj = service.findById(id);
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
//        list.addAll(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(new UserDTO(obj));
    }

}
