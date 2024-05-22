package com.curso.Suporteos.controller;

import com.curso.Suporteos.Services.UsersService;
import com.curso.Suporteos.domains.dto.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<UsersDTO>> findAll(){
        return ResponseEntity.ok().body(usersService.findAll());
    }
}
