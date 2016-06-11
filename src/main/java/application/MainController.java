package application; /**
 * Created by MSI on 20.04.2016.
 */
import data.dishaccess.DishesRepository;
import model.entities.Client;
import model.entities.Dish;
import model.comparators.SortByPrice;
import model.logic.ServiceLayer;
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

    ServiceLayer serviceLayer = ServiceLayer.getInstance();

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome()
    {
        return "index";
    }

    @RequestMapping("/addClient")
    public ModelAndView requestHandlingMethod(Client client) {
        ModelAndView model = new ModelAndView();
        List<Dish> menu= serviceLayer.getMenu();
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