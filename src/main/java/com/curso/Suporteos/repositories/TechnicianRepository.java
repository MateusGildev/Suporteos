package com.curso.Suporteos.repositories;

import com.curso.Suporteos.Entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, UUID> {

    Optional<Technician> findByCpf(String cpf);

    Optional<Technician> findByEmail(String email);
}
