

import application.Service;
import application.Start;
import model.entities.Dish;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.BootstrapWith;

//import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;


/**
 * Created by MSI on 03.08.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Start.class)
public class ServiceIntegrationTest
{

    @Autowired
    Service service;

    @Test
    public void examineMenu()
    {
        Dish greekSalad = service.findByName("Greek salad");
        List<Dish> menu = service.getMenu();
        assert(greekSalad.getName().equals("Greek salad"));
        assert (menu.size()==3);
    }
}
