package com.curso.Suporteos.Entity;

import com.curso.Suporteos.Services.ServiceOrder;
import com.curso.Suporteos.domains.dto.UsersDTO;
import com.curso.Suporteos.domains.enums.PersonType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
public class Users extends Person {
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<ServiceOrder> serviceOrders = new ArrayList<>();

    public Users(UUID id, String firstName, String lastName, String cpf, String email, String password) {
        super(id, firstName, lastName, cpf, email, password);
        addPersonType(PersonType.USERS);
    }

    public Users() {
        super();
        addPersonType(PersonType.USERS);
    }

    public Users(UsersDTO usersDTO) {
        this.id = usersDTO.getId();
        this.firstName = usersDTO.getFirstName();
        this.lastName = usersDTO.getLastName();
        this.cpf = usersDTO.getCpf();
        this.email = usersDTO.getEmail();
        this.password = usersDTO.getPassword();
        this.createAt = usersDTO.getCreatedAt();
        this.personType = usersDTO.getPersonType().stream().map(x -> x.getId()).collect(Collectors.toSet());
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
