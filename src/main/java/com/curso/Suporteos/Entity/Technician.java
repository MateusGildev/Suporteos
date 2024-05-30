package com.curso.Suporteos.Entity;

import com.curso.Suporteos.Services.ServiceOrder;
import com.curso.Suporteos.domains.dto.TechnicianDTO;
import com.curso.Suporteos.domains.enums.PersonType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
public class Technician extends Person{
    @JsonIgnore
    @OneToMany(mappedBy = "technician")
    private List<ServiceOrder> serviceOrders = new ArrayList<>();

    public Technician(UUID id, String firstName, String lastName, String cpf, String email, String password) {
        super(id, firstName, lastName, cpf, email, password);
        addPersonType(PersonType.TECHNICIAN);
    }

    public Technician(){
        super();
        addPersonType(PersonType.TECHNICIAN);
    }

    public Technician(TechnicianDTO technicianDTO) {
        this.id = technicianDTO.getId();
        this.firstName = technicianDTO.getFirstName();
        this.lastName = technicianDTO.getLastName();
        this.cpf = technicianDTO.getCpf();
        this.email = technicianDTO.getEmail();
        this.password = technicianDTO.getPassword();
        this.createAt = technicianDTO.getCreatedAt();
        this.personType = technicianDTO.getPersonType().stream().map(x -> x.getId()).collect(Collectors.toSet());
        addPersonType(PersonType.TECHNICIAN);
        addPersonType(PersonType.USERS);
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}
