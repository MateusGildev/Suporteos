package com.curso.Suporteos.Services;

import com.curso.Suporteos.Entity.Technician;
import com.curso.Suporteos.Entity.Users;
import com.curso.Suporteos.Services.exceptions.ObjectNotFoundException;
import com.curso.Suporteos.domains.dto.TechnicianDTO;
import com.curso.Suporteos.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository technicianRepository;

    public List<TechnicianDTO> findAll() {
        return technicianRepository.findAll().stream().map(obj -> new TechnicianDTO(obj)).collect(Collectors.toList());
    }

    public Technician findById(UUID id) {
        Optional<Technician> optionalTechnician = technicianRepository.findById(id);
        return optionalTechnician.orElse(null);
    }

    public Technician findByCpf(String cpf) {
        Optional<Technician> optionalTechnician = technicianRepository.findByCpf(cpf);
        return optionalTechnician.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! CPF:" + cpf));
    }

    public Technician create(TechnicianDTO technicianDTO) {
        technicianDTO.setId(null);
        Technician technician = new Technician(technicianDTO);
        return technicianRepository.save(technician);
    }

    public Technician findByEmail(String email) {
        Optional<Technician> technician = technicianRepository.findByEmail(email);
        return technician.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + email));
    }
}
