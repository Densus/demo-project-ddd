package com.orderbook.platform;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigurationApplication {
    private static Class<ConfigurationApplication> application = ConfigurationApplication.class;
    public static void main(String[] args) {
        SpringApplication.run(application, args);
    }

}
