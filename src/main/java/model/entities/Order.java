package model.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MSI on 20.07.2016.
 */
public class Order {
    private Map<Dish, Integer> orders= new HashMap<>();


    private Client client;

    public Order() {
    }

    public Order(Client client) {
        this.client = client;
    }

    public Order(Map<Dish, Integer> orders, Client client) {
        this.orders = orders;
        this.client = client;
    }


    public Map<Dish, Integer> getOrders() {
        return orders;
    }


    public void addDishAndAmountToOrderList(Dish dish, int amount)
    {
        orders.put(dish, amount);
    }

    public void addAllDishesToOrderList(Map<Dish,Integer> dishes)
    {
        orders.putAll(dishes);
    }

    public Client getClient()
    {
        return this.client;
    }

}

