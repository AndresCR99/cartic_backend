package com.backend.carticback;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    
    Dotenv dotenv = Dotenv.load();
    
    public void dbProperties(){
        /* ...
        */
        String dbUrl = dotenv.get("SPRING_DATASOURCE_LOCAL", "jdbc:mysql://127.0.0.1:3306/cartic?createDatabaseIfNotExist=true");
        String dbUsername = dotenv.get("SPRING_DB_USERNAME", "root");
        String dbPassword = dotenv.get("SPRING_DB_PASSWORD", "");
        String dbAutoUpdate = dotenv.get("SPRING_AUTO_UPDATE_DB", "update");

        System.setProperty("spring.datasource.url", dbUrl);
        System.setProperty("spring.datasource.username", dbUsername);
        System.setProperty("spring.datasource.password", dbPassword);
        System.setProperty("spring.jpa.hibernate.ddl-auto", dbAutoUpdate);
    }

}
