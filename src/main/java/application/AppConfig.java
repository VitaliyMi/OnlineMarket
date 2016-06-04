package application;

import data.DAOClass;
import data.DAOHibernateImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by MSI on 30.04.2016.
 */
@Configuration
@ComponentScan("java")
public class AppConfig {

    @Bean
    public EntityManager entityManager()
   {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("MarketOnline");
       return emf.createEntityManager();
   }

    @Bean
    public DAOClass daoClass()
    {
        return new DAOHibernateImpl();
    }
}
