package application;

import data.DAOClass;
import data.DAOHibernateImpl;
import data.dishaccess.DishesRepository;

import model.entities.Dish;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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

@EnableJpaRepositories(basePackageClasses = DishesRepository.class)

public class AppConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.h2.Driver");
        basicDataSource.setUrl("jdbc:h2:mem:testdb");
        basicDataSource.setUsername("sa");
        basicDataSource.setPassword("");
        return (DataSource) basicDataSource;
    }

    /**
     * Factory to create a especific instance of Entity Manager
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        entityManager.setPackagesToScan("model.entities");
        entityManager.setPersistenceProvider(new HibernatePersistenceProvider());
        entityManager.setJpaProperties(jpaProperties());

        return entityManager;
    }

    /**
     * Properties for Jpa
     */
    private static Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        return properties;
    }

    /**
     * Get transaction manager
     */
    @Bean
    public JpaTransactionManager transactionManager() throws SQLException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
