package application;

import data.dishaccess.DishesRepository;
import model.comparators.SortByPrice;
import model.entities.Dish;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by MSI on 30.06.2016.
 */
public interface Service {




    public List<Dish> getMenu();

    public List<Dish> getSortedByPriceMenu();

    public void addDish();

    public Dish findByName(String name);

}
