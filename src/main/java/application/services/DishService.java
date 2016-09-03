package application.services;

import application.model.Dish;
import application.repositories.DishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI on 08.06.2016.
 */
@Component("service")
public class DishService implements Service {

    private DishesRepository repository;


    @Autowired
    public DishService(DishesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Dish> getMenu() {
        List<Dish> dishList = repository.findAll();
        return dishList;
    }

    @Override
    public List<Dish> getSortedByPriceMenu() {
        return new ArrayList<>();
    }


    @Override
    public Dish findByName(String name) {
        return repository.findByDishNameIgnoreCase(name);

    }

    public List<Dish> performSortedSearch(String sorter)
    {
        if("price".equals(sorter))
        {
            return repository.findAllByOrderByPriceAsc();
        }
        if ("name".equals(sorter))
        {
            return repository.findAllByOrderByDishNameAsc();
        }
        return new ArrayList<>();
    }

}
