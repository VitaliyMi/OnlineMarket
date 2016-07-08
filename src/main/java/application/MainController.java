package application; /**
 * Created by MSI on 20.04.2016.
 */
import model.entities.Client;
import model.entities.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/")
@SessionAttributes(types = Client.class)
public class MainController {

    @Autowired
    Service service;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome()
    {
        return "index";
    }

    @RequestMapping("/addClient")
    public ModelAndView requestHandlingMethod(Client client) {
        ModelAndView model = new ModelAndView();
        List<Dish> menu= service.getMenu();
        model.addObject("menuList", menu);
        model.setViewName("menulist");
        service.addDish();
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