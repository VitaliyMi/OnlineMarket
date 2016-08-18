package data.dishaccess;

import model.entities.Dish;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.repository.Repository;

import java.util.List;


/**
 * Created by MSI on 05.06.2016.
 */
public interface DishesRepository  extends Repository<Dish, Integer> {

   List<Dish> findAll();

   Dish findByNameIgnoreCase(String dishName);
}
