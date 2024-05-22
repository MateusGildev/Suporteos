package com.curso.Suporteos.Services;

import com.curso.Suporteos.domains.dto.TechnicianDTO;
import com.curso.Suporteos.domains.dto.UsersDTO;
import com.curso.Suporteos.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository technicianRepository;

    public List<TechnicianDTO> findAll(){
        return technicianRepository.findAll().stream().map(obj -> new TechnicianDTO(obj)).collect(Collectors.toList());
    }
}
