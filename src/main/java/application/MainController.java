package application; /**
 * Created by MSI on 20.04.2016.
 */
import data.dishaccess.DishesRepository;
import model.Client;
import model.Dish;
import model.comparators.SortByPrice;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/")
@SessionAttributes(types = Client.class)
public class MainController {

    private static AnnotationConfigApplicationContext ctx;
    static
    {

       ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
    }
 //   @Autowired
 //   DAOClass dao;


    DishesRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome()
    {
        return "index";
    }

    @RequestMapping("/addClient")
    public ModelAndView requestHandlingMethod(Client client) {
        repository=ctx.getBean(DishesRepository.class);
        ModelAndView model = new ModelAndView();
       // System.out.println(client.getName());
        List<Dish> menu= (List<Dish>) repository.findAll();
          Collections.sort(menu, new SortByPrice());
       // Collections.sort(menu, new SortByName());
        for (Dish d : menu)
        {
            System.out.println(d);
        }
        model.addObject("menuList", menu);
        model.setViewName("menulist");

        return model;
    }

    @RequestMapping(value = "/processOrder")
    public String showCart(HttpServletRequest request)
    {
        String i=request.getParameter("numberof");
        System.out.println(i);
        return "index";
    }


}