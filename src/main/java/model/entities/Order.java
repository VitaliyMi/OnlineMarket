package model.entities;

import java.util.*;

/**
 * Created by MSI on 20.07.2016.
 */
public class Order {
    private Map<Dish, Integer> dishes= new HashMap<>();


    private Client client;

    public Order() {
    }

    public Order(Client client) {
        this.client = client;
    }

    public Order(Map<Dish, Integer> orders, Client client) {
        this.dishes = orders;
        this.client = client;
    }


    public Map<Dish, Integer> getDishes() {
        return dishes;
    }


    public void addDishAndAmountToOrderList(Dish dish, int amount)
    {
        dishes.put(dish, amount);
    }

    public void addAllDishesToOrderList(Map<Dish,Integer> dishes)
    {
        dishes.putAll(dishes);
    }

    public Client getClient()
    {
        return this.client;
    }



}

