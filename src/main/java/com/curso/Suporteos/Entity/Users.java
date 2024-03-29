package com.curso.Suporteos.Entity;

import com.curso.Suporteos.Services.ServiceOrder;
import com.curso.Suporteos.domains.enums.PersonType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Users extends Person {
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

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}
