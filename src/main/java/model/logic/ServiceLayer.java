package model.logic;

import application.AppConfig;
import data.DAOClass;
import data.dishaccess.DishesRepository;
import model.comparators.SortByPrice;
import model.entities.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by MSI on 08.06.2016.
 */
public class ServiceLayer {


    private static AnnotationConfigApplicationContext ctx;
    static
    {
        ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
    }


//    @Autowired
    DAOClass daoClass= (DAOClass) ctx.getBean("daoClass");
//    DishesRepository repository= ctx.getBean(DishesRepository.class);

    private ServiceLayer(){}

    private static ServiceLayer instance;

//    private List<Dish> cachedMenu = (List<Dish>) repository.findAll();
    private List<Dish> cachedMenu = daoClass.getMenu();

    public static ServiceLayer getInstance()
    {
        if(instance==null)
        {
            instance=new ServiceLayer();
        }
        return instance;
    }

    public List<Dish> getMenu()
    {
        return cachedMenu;
    }

    public List<Dish> getSortedByPriceMenu()
    {
        List<Dish> sortedMenu = new ArrayList<>(cachedMenu);
        Collections.sort(sortedMenu, new SortByPrice());
        return sortedMenu;
    }



}
