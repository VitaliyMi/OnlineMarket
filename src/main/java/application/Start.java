package application;

import data.DBInitializer;
import data.dishaccess.DishesRepository;
import model.entities.Dish;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLException;

/**
 * Created by MSI on 17.05.2016.
 */

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = DishesRepository.class)
//@ComponentScan("src.main.java.model.entities")
@EntityScan("model.entities")
public class Start {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Start.class, args);
     //   DBInitializer.checkData();
    }

}
