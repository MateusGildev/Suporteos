package com.curso.Suporteos.Services;

import com.curso.Suporteos.Entity.Technician;
import com.curso.Suporteos.Entity.Users;
import com.curso.Suporteos.Services.exceptions.ObjectNotFoundException;
import com.curso.Suporteos.domains.dto.TechnicianDTO;
import com.curso.Suporteos.domains.dto.UsersDTO;
import com.curso.Suporteos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public List<UsersDTO> findAll() {
        return userRepository.findAll().stream().map(obj -> new UsersDTO(obj)).collect(Collectors.toList());
    }

    public Users findById(UUID id) {
        Optional<Users> optionalUsers = userRepository.findById(id);
        return optionalUsers.orElseThrow(() -> new ObjectNotFoundException("Obejto nao encontrado! ID:" + id));
    }

    public Users findByCpf(String cpf) {
        Optional<Users> optionalUser = userRepository.findByCpf(cpf);
        return optionalUser.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! CPF:" + cpf));
    }

    public Users findByEmail(String email) {
        Optional<Users> user = userRepository.findByEmail(email);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! " + email));
    }

    public Users create(UsersDTO usersDTO) {
        usersDTO.setId(null);
        Users user = new Users(usersDTO);
        return userRepository.save(user);
    }
}
