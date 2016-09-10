package application.model;

import java.io.Serializable;
import java.util.*;

/**
 * Created by MSI on 20.07.2016.
 */
public class Order implements Serializable {
    private int id;

    private Map<Dish, Integer> dishes = new HashMap<>();

    private Client client;

    public Order() {
        //explicit public constructor;
    }

    public Order(Client client) {
        this.client = client;
    }

    public Order(Client client,Map<Dish, Integer> orders) {
        this.dishes = orders;
        this.client = client;
    }


    public int getId() {
        return id;
    }

    public Map<Dish, Integer> getDishes() {
        return dishes;
    }


    public void addDishAndAmountToOrderList(Dish dish, int amount) {
        dishes.put(dish, amount);
    }

    public void addAllDishesToOrderList(Map<Dish, Integer> dishes) {
        dishes.putAll(dishes);
    }


    public Client getClient() {
        return this.client;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Order))
            return false;
        Order order = (Order) o;
        if (!client.equals(order.client))
            return false;
        if (!dishes.equals(order.dishes))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dishes.hashCode();
        result = 31 * result + client.hashCode();
        return result;
    }
}

