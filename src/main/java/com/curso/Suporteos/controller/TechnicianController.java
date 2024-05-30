package com.curso.Suporteos.controller;

import com.curso.Suporteos.Entity.Technician;
import com.curso.Suporteos.Services.TechnicianService;
import com.curso.Suporteos.domains.dto.TechnicianDTO;
import com.curso.Suporteos.domains.dto.UsersDTO;
import com.fasterxml.jackson.annotation.OptBoolean;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/tech")
public class TechnicianController {

    @Autowired
    private TechnicianService technicianService;

    @GetMapping
    public ResponseEntity<List<TechnicianDTO>> findAll(){
        return ResponseEntity.ok().body(technicianService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnicianDTO> findById(@PathVariable UUID id){
        Technician technician = technicianService.findById(id);
        return ResponseEntity.ok().body(new TechnicianDTO(technician));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<TechnicianDTO> findByCpf(@PathVariable String cpf){
        Technician technician = technicianService.findByCpf(cpf);
        return ResponseEntity.ok().body(new TechnicianDTO(technician));
    }

    @PostMapping
    public ResponseEntity<TechnicianDTO> create(@RequestBody @Valid TechnicianDTO technicianDTO){
        Technician newTechnician = technicianService.create(technicianDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newTechnician.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<TechnicianDTO> findByEmail(@PathVariable String email){
        Technician technician = technicianService.findByEmail(email);
        return ResponseEntity.ok().body(new TechnicianDTO(technician));
    }
}
