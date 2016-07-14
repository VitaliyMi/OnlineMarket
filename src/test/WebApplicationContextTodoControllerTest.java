

/**
 * Created by MSI on 14.06.2016.
 */


import application.MainController;
import context.WebAppContext;
import data.dishaccess.DishesRepository;
import model.entities.Dish;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@WebAppConfiguration
public class WebApplicationContextTodoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private MainController mainControllerMock;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Autowired
    DishesRepository repository;
    @Before
    public void setUp() {
        //We have to reset our mock between tests because the mock objects
        //are managed by the Spring container. If we would not reset them,
        //stubbing and verified behavior would "leak" from one test to another.
        Mockito.reset(mainControllerMock);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void saveDishes()
    {
        Dish d = new Dish();
        d.setName("one");
        d.setPrice(1);
        d.setUrl("");
      //  repository.save(d);
    }

    @Test
    public void countDishes()
    {
        List<Dish> dishList = (List<Dish>) repository.findAll();
      //  assert (dishList.size()==4);
    }

}