package com.curso.Suporteos.domains.dto;

import com.curso.Suporteos.Entity.Technician;
import com.curso.Suporteos.domains.enums.PersonType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class TechnicianDTO {

    protected UUID id;
    @NotNull(message = "O campo nome nao deve ser nulo")
    @NotBlank(message = "O campo nome nao pode ter espaços vazios")
    protected String firstName;
    @NotNull(message = "O campo sobrenome nao deve ser nulo")
    @NotBlank(message = "O campo sobrenome nao pode ter espaços vazios")
    protected String lastName;

    @NotNull(message = "O campo cpf nao deve ser nulo")
    @NotBlank(message = "O campo cpf nao pode ter espaços vazios")
    protected String cpf;

    @NotNull(message = "O campo email nao deve ser nulo")
    @NotBlank(message = "O campo email nao pode ter espaços vazios")
    protected String email;
    @NotNull(message = "O campo senha nao deve ser nulo")
    @NotBlank(message = "O campo senha nao pode ter espaços vazios")
    protected String password;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdAt = LocalDate.now();

    protected Set<Integer> personType = new HashSet<>();

    public TechnicianDTO() {
    }

    public TechnicianDTO(Technician obj) {
        this.id = obj.getId();
        this.firstName = obj.getFirstName();
        this.lastName = obj.getLastName();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.createdAt = obj.getCreateAt();
        this.personType = obj.getPersonType().stream().map(x -> x.getId()).collect(Collectors.toSet());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Set<PersonType> getPersonType() {
        return personType.stream().map(x -> PersonType.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPersonType(PersonType personType) {
        this.personType.add(personType.getId());
    }
}
