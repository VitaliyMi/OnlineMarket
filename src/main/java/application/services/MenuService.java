package application.services;

import application.model.Dish;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MenuService {

    public List<Dish> getMenu();

    public List<Dish> getSortedByPriceMenu();

    public Dish findByName(String name);

}