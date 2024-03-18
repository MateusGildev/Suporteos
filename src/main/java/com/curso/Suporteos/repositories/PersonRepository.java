package com.curso.Suporteos.repositories;

import com.curso.Suporteos.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
}
