import application.AppConfig;
import data.dishaccess.DishesRepository;
import model.Dish;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by MSI on 07.06.2016.
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.register(AppConfig.class);
            ctx.refresh();


        DishesRepository dishesRepository=ctx.getBean(DishesRepository.class);

        List<Dish> d= (List<Dish>) dishesRepository.findAll();
    }
}
