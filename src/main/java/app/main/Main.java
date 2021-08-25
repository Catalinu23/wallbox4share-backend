package app.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "app.repository")
@ComponentScan(basePackages = {"app.service",
                               "app.controller"})
@EntityScan(basePackages = "app.entity")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
