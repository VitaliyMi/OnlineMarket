package data.dishaccess;

import model.entities.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;


/**
 * Created by MSI on 05.06.2016.
 */

public interface DishesRepository  extends Repository<Dish, Integer> {
   // Dish findByName(String name);

   List<Dish> findAll();
}
