package data;

import model.Client;
import model.Dish;
import model.Transaction;

import java.util.List;

/**
 * Created by MSI on 30.04.2016.
 */
public interface DAOClass {
    List<Dish> getMenu();
    void addClient(Client client);
    Client getClient(String identifier);
    void updateClient(Client client);
    void deleteClient(Client client);
    void addDish(Dish dish);
    Dish getDish(String dishname);
    void saveTransactions(List<Transaction> transactions);

}
