package application;

import data.dishaccess.DishesRepository;
import model.comparators.SortByPrice;
import model.entities.Dish;
import application.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by MSI on 08.06.2016.
 */
@Component("service")
public class ServiceLayer implements Service {

    private DishesRepository repository;

    @Autowired
    public ServiceLayer(DishesRepository repository)
    {
        this.repository=repository;
    }

    public ServiceLayer()
    {

    }

    private List<Dish> cachedMenu;

    public List<Dish> getMenu()
    {
        cachedMenu = repository.findAll();
        return cachedMenu;
    }

    public List<Dish> getSortedByPriceMenu()
    {
        List<Dish> sortedMenu = new ArrayList<>(cachedMenu);
        Collections.sort(sortedMenu, new SortByPrice());
        return sortedMenu;
    }

    public void addDish()
    {
        Dish d = new Dish("Hleb");
        d.setPrice(12);
        d.setUrl("url");
        System.out.println("Supposed to be saved");
        cachedMenu= repository.findAll();
    }

    public Dish findByName(String name)
    {
       Dish dish = repository.findByNameIgnoreCase(name);
        return dish;
    }
}
