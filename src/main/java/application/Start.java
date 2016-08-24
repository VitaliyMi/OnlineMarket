package application;

import application.web.MainController;
import org.springframework.context.annotation.ComponentScan;
import application.repositories.dishRepository.DishesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.ControllerAdvice;


/**
 * Created by MSI on 17.05.2016.
 */

@SpringBootApplication
public class Start {

    public static void main(String[] args){
        SpringApplication.run(Start.class, args);
    }

}
