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


 /*   private static AnnotationConfigApplicationContext ctx;
    static
    {
        ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
    }
*/
 private DishesRepository repository;

    @Autowired
    public ServiceLayer(DishesRepository repository)
    {
        this.repository=repository;
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public ServiceLayer()
    {
        System.out.println("IN CONSTRUCTOR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    //    @Autowired
//    DAOClass daoClass= (DAOClass) ctx.getBean("daoClass");= ctx.getBean(DishesRepository.class)


    private List<Dish> cachedMenu;
//    private List<Dish> cachedMenu = daoClass.getMenu();



    public List<Dish> getMenu()
    {
        cachedMenu=(List<Dish>) repository.findAll();
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
    //    repository.save(d);
        System.out.println("Supposed to be saved");
        cachedMenu= (List<Dish>) repository.findAll();
    }
}
