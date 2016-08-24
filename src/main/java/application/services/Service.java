package application.services;

/**
 * Created by MSI on 21.08.2016.
 */

import application.model.entities.Dish;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by MSI on 30.06.2016.
 */
@Component
public interface Service {




    public List<Dish> getMenu();

    public List<Dish> getSortedByPriceMenu();

    public void addDish();

    public Dish findByName(String name);

}