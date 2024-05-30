package com.curso.Suporteos.repositories;

import com.curso.Suporteos.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {

    Optional<Users> findByCpf(String cpf);
    Optional<Users> findByEmail(String email);
}
