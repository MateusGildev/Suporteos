package com.curso.Suporteos.Services;

import com.curso.Suporteos.Entity.Technician;
import com.curso.Suporteos.Entity.Users;
import com.curso.Suporteos.domains.enums.OrderPriority;
import com.curso.Suporteos.domains.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_serviceOrder")
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate starDate = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;

    private String titleOS;
    private String description;
    private OrderPriority orderPriority;
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "id_technician")
    private Technician technician;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users user;

    public ServiceOrder(UUID id, String titleOS, String description, OrderPriority orderPriority, OrderStatus orderStatus, Technician technician, Users user) {
        this.id = id;
        this.titleOS = titleOS;
        this.description = description;
        this.orderPriority = orderPriority;
        this.orderStatus = orderStatus;
        this.technician = technician;
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ServiceOrder other = (ServiceOrder) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
