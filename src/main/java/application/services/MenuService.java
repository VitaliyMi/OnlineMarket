package application.services;

import application.model.Dish;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface MenuService {

    public List<Dish> getMenu();

    public List<Dish> performSortedSearch(Optional<String> sorter);

    public Dish findByName(String name);

}