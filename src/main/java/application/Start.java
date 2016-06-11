package application;

import data.DBInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

/**
 * Created by MSI on 17.05.2016.
 */


@SpringBootApplication
public class Start {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Start.class, args);
        DBInitializer.checkData();
    }

}
