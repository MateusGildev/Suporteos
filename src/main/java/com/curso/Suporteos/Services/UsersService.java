package com.curso.Suporteos.Services;

import com.curso.Suporteos.domains.dto.UsersDTO;
import com.curso.Suporteos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public List<UsersDTO> findAll(){
        return userRepository.findAll().stream().map(obj -> new UsersDTO(obj)).collect(Collectors.toList());
    }
}
