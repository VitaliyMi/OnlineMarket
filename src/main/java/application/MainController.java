package application; /**
 * Created by MSI on 20.04.2016.
 */
import data.DAOClass;
import model.Client;
import model.Dish;
import model.comparators.SortByName;
import model.comparators.SortByPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/")
@SessionAttributes(types = Client.class)
public class MainController {

    @Autowired
    DAOClass dao;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome()
    {
        return "index";
    }

    @RequestMapping("/addClient")
    public ModelAndView requestHandlingMethod(Client client) {
        ModelAndView model = new ModelAndView();
       // System.out.println(client.getName());
        List<Dish> menu=dao.getMenu();
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