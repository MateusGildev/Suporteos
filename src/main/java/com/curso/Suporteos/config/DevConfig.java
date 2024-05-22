package com.curso.Suporteos.config;

import com.curso.Suporteos.Services.DbService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
@Configuration
@Profile("dev")
public class DevConfig {
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @Autowired
    private DbService dbService;
    @PostConstruct
    public void initDB(){
        if (value.equals("create")){
            this.dbService.initDB();
        }
    }
}
