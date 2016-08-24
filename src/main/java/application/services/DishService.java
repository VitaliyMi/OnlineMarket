package application.services;

import application.model.entities.Dish;
import application.repositories.dishRepository.DishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by MSI on 08.06.2016.
 */
@Component("service")
public class DishService implements Service {

    private DishesRepository repository;

    public DishService()
    {

    }

    @Autowired
    public DishService(DishesRepository repository) {
        this.repository = repository;
    }

    private List<Dish> cachedMenu;

    public List<Dish> getMenu() {
        cachedMenu = repository.findAll();
        return cachedMenu;
    }

    @Override
    public List<Dish> getSortedByPriceMenu() {
        return null;
    }

    public void addDish() {
        Dish d = new Dish("Hleb");
        d.setPrice(12);
        d.setUrl("url");
        System.out.println("Supposed to be saved");
        cachedMenu = repository.findAll();
    }

    public Dish findByName(String name) {
        Dish dish = repository.findByNameIgnoreCase(name);
        return dish;
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
        return null;
    }

}
