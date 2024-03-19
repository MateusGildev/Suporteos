package com.curso.Suporteos.Services;


import com.curso.Suporteos.Entity.Technician;
import com.curso.Suporteos.Entity.Users;
import com.curso.Suporteos.domains.enums.OrderPriority;
import com.curso.Suporteos.domains.enums.OrderStatus;
import com.curso.Suporteos.repositories.ServiceOrderRepository;
import com.curso.Suporteos.repositories.TechnicianRepository;
import com.curso.Suporteos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    @Autowired
    private TechnicianRepository technicianRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;


    public void initDB(){
        Technician tec1 = new 
        Technician(null, "Jeffeson", "Passerini", "98765432100", "jefferson@gmail.com", "123");

        Users user1 = new
                Users(null,"Mateus", "Gil", "08357624155", "mateus@gmail.com","0701");

        Users user2 = new
                Users(null,"Jorge", "Silva", "123456", "jorge@gmail.com","321");

        ServiceOrder os01 = new
                ServiceOrder(null,"test", "OS TEST", OrderPriority.HIGH, OrderStatus.OPEN, tec1, user2);

        technicianRepository.save(tec1);
        userRepository.save(user1);
        userRepository.save(user2);
        serviceOrderRepository.save(os01);



    }
        
}
