package application.services;

import application.model.entities.Dish;
import application.repositories.dishrepository.DishesRepository;
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

    private List<Dish> cachedMenu;

    @Autowired
    public DishService(DishesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Dish> getMenu() {
        cachedMenu = repository.findAll();
        return cachedMenu;
    }

    @Override
    public List<Dish> getSortedByPriceMenu() {
        return new ArrayList<>();
    }

    @Override
    public void addDish() {
        Dish d = new Dish("Hleb");
        d.setPrice(12);
        d.setUrl("url");
        cachedMenu = repository.findAll();
    }

    @Override
    public Dish findByName(String name) {
        return repository.findByNameIgnoreCase(name);

    }

    public List<Dish> performSortedSearch(String sorter)
    {
        if("price".equals(sorter))
        {
            return repository.findAllByOrderByPriceAsc();
        }
        if ("name".equals(sorter))
        {
            return repository.findAllByOrderByNameAsc();
        }
        return new ArrayList<>();
    }

}
