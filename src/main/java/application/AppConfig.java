package application;

import data.DAOClass;
import data.DAOHibernateImpl;
import data.dishaccess.DishesRepository;
import jdk.management.resource.internal.inst.DatagramDispatcherRMHooks;
import model.entities.Dish;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by MSI on 30.04.2016.
 */


@Configuration
@ComponentScan("java")
@EnableJpaRepositories("data")
@EntityScan("model.entities")
@EnableAutoConfiguration
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

   /* @Bean
    public EntityManagerFactory entityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MarketOnline");
        return emf;
    }

   @Bean(destroyMethod = "close")
   public DataSource dataSource() {
       BasicDataSource basicDataSource = new BasicDataSource();
       basicDataSource.setDriverClassName("org.h2.Driver");
       basicDataSource.setUrl("jdbc:h2:mem:testdb");
       basicDataSource.setUsername("sa");
       basicDataSource.setPassword("");
       return (DataSource) basicDataSource;
   }

    /*
     * Factory to create a especific instance of Entity Manager

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        entityManager.setPackagesToScan("data");
        entityManager.setPersistenceProvider(new HibernatePersistenceProvider());
        entityManager.setJpaProperties(jpaProperties());

        return entityManager;
    }

    /**
     * Properties for Jpa

    private static Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        return properties;
    }

    /**
     * Get transaction manager

    @Bean
    public JpaTransactionManager transactionManager() throws SQLException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
     */
}
