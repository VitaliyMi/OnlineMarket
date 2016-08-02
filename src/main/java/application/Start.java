package application;

import data.dishaccess.DishesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLException;

/**
 * Created by MSI on 17.05.2016.
 */

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = DishesRepository.class)
@EntityScan("model.entities")
public class Start {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Start.class, args);
    }

}
