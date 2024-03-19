package com.curso.Suporteos.config;

import com.curso.Suporteos.Services.DbService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private DbService dbService;

    @PostConstruct
    public void initDB()
    {
        this.dbService.initDB();
    }
}
