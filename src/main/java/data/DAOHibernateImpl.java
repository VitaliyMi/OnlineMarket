package data;

import model.entities.Client;
import model.entities.Dish;
import model.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

/**
 * Created by MSI on 30.04.2016.
 */
public class DAOHibernateImpl implements DAOClass{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Dish> getMenu() {
        TypedQuery query = entityManager.createQuery("Select d from Dish d", Dish.class);
        return  query.getResultList();
    }

    @Override
    public void addClient(Client client) {
        entityManager.getTransaction().begin();
        entityManager.merge(client);
        entityManager.getTransaction().commit();
        System.out.println("----------------------Client"+ client.getName()+" Added---------------------------");
    }

    @Override
    public Client getClient(String identifier) {
        TypedQuery<?> query = entityManager.createQuery("SELECT c from Client c where c.name =:name",Client.class);
        query.setParameter("name", identifier);
        return (Client)query.getSingleResult();}

    @Override
    public void updateClient(Client client) {
    }

    @Override
    public void deleteClient(Client client) {
    }

    public Dish getDish(String name)
    {
        TypedQuery<?> query = entityManager.createQuery("SELECT d from Dish d where d.name =:name",Dish.class);
        query.setParameter("name", name);
        return (Dish)query.getSingleResult();
    }

    @Override
    public void saveTransactions(List<Transaction> transactions) {


    }

    public void addDish(Dish d)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(d);
        entityManager.getTransaction().commit();
    }
}
