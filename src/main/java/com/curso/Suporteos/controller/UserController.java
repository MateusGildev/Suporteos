package com.curso.Suporteos.controller;

import com.curso.Suporteos.Entity.Technician;
import com.curso.Suporteos.Entity.Users;
import com.curso.Suporteos.Services.UsersService;
import com.curso.Suporteos.domains.dto.TechnicianDTO;
import com.curso.Suporteos.domains.dto.UsersDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<UsersDTO>> findAll() {
        return ResponseEntity.ok().body(usersService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsersDTO> findById(@PathVariable UUID id) {
        Users user = usersService.findById(id);
        return ResponseEntity.ok().body(new UsersDTO(user));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<UsersDTO> findByCpf(@PathVariable String cpf) {
        Users user = usersService.findByCpf(cpf);
        return ResponseEntity.ok().body(new UsersDTO(user));
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<UsersDTO> findByEmail(@PathVariable String email) {
        Users user = usersService.findByEmail(email);
        return ResponseEntity.ok().body(new UsersDTO(user));
    }

    @PostMapping
    public ResponseEntity<UsersDTO> create(@RequestBody @Valid UsersDTO usersDTO){
        Users newUser = usersService.create(usersDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
