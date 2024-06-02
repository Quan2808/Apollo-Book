package com.apollo.bookstore.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.apollo.bookstore.library.*", "com.apollo.bookstore.server.*"})
@EntityScan(value = "com.apollo.bookstore.library.models")
@EnableJpaRepositories(value = "com.apollo.bookstore.library.repositories")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
