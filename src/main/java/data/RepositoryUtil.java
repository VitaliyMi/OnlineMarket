package data;

import application.AppConfig;
import data.clientaccess.UsersRepository;
import data.dishaccess.DishesRepository;
import model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by MSI on 05.06.2016.
 */
public class RepositoryUtil {
    private static AnnotationConfigApplicationContext ctx;
    static
    {
        ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
    }

    private UsersRepository usersRepository;
    @Autowired
    private static DishesRepository dishRepository=ctx.getBean(DishesRepository.class);


    public static void main(String[] args) {
        dishRepository.save(new Dish("Borstch"));
    }


}
