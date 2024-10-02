package com.test.springParactice.basicSpring;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
//@Component
//@ConfigurationProperties(prefix = "database.connector")
public class DatabaseConnector {
//    @Value("${database.connector.url}")
    private String url;
    private String dbName;
    private String password;
//    private String osName;

    public DatabaseConnector(@Autowired Environment env){
        this.url = env.getProperty("database.connector.url");
        this.dbName = env.getProperty("database.connector.dbName");
        this.password = env.getProperty("database.connector.password");
//        this.osName = env.getProperty("user.country");

    }
}
