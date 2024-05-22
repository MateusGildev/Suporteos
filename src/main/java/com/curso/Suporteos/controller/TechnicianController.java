package com.curso.Suporteos.controller;

import com.curso.Suporteos.Services.TechnicianService;
import com.curso.Suporteos.domains.dto.TechnicianDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tech")
public class TechnicianController {

    @Autowired
    private TechnicianService technicianService;

    @GetMapping
    public ResponseEntity<List<TechnicianDTO>> findAll(){
        return ResponseEntity.ok().body(technicianService.findAll());
    }
}
