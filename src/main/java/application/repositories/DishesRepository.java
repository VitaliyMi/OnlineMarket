package application.repositories;

import application.model.Dish;
import org.springframework.data.repository.Repository;

import java.util.List;


/**
 * Created by MSI on 05.06.2016.
 */
public interface DishesRepository  extends Repository<Dish, Integer>
{

   List<Dish> findAll();

   Dish findByDishNameIgnoreCase(String dishName);

   List<Dish> findAllByOrderByDishNameAsc();

   List<Dish> findAllByOrderByPriceAsc();

}
