package data.dishaccess;

import model.Dish;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MSI on 05.06.2016.
 */
@Repository
public interface DishesRepository  extends CrudRepository<Dish, Integer>, JpaSpecificationExecutor<Dish>{
    Dish findByName();
}
