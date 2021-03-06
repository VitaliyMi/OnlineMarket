import application.Start;
import application.model.Dish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import application.services.DefaultMenuService;

import java.util.List;


/**
 * Created by MSI on 03.08.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Start.class)
public class MenuServiceIntegrationTest {

    @Autowired
    DefaultMenuService dishService;

    @Test
    public void examineMenu() {
        Dish greekSalad = dishService.findByName("Greek salad");
        List<Dish> menu = dishService.getMenu();
        assert (greekSalad.getName().equals("Greek salad"));
        assert (menu.size() == 3);
    }
}
