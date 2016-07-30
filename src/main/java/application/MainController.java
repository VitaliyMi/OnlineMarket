package application; /**
 * Created by MSI on 20.04.2016.
 */
import model.entities.Client;
import model.entities.Dish;
import model.entities.Order;
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

    private static List<Order> orders = new ArrayList<>();

    @Autowired
    Service service;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printWelcome()
    {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("client", new Client());
        return mav;
    }


    @RequestMapping("/addClient")
    public ModelAndView requestHandlingMethod(HttpServletRequest request,@ModelAttribute Client client) {
        String name = request.getParameter("name");
        System.out.println("Clientname: "+ client.getName());
        ModelAndView model = new ModelAndView("menulist");
        List<Dish> menu= service.getMenu();
        model.addObject("menuList", menu);
        Order o = new Order();
        model.addObject("order", o);
    //    model.addObject("client",client);
        return model;
    }


    @RequestMapping(value = "/processOrder")
    public ModelAndView showCart(@ModelAttribute Client client, HttpServletRequest request)
    {

        System.out.println("Client in result: "+client.getName());
        Order order = new Order(client);
        String[] orderedDishesNames =request.getParameterValues("selected");
        System.out.println(orderedDishesNames==null? "order is null":"Ok");
        for(String s: orderedDishesNames)
        {
            Dish dish = service.findByName(s);
            System.out.println(dish.getName()+"\t "+ dish.getPrice());
            int piecesOrdered =Integer.parseInt(request.getParameter("numberof" + s));
            order.addDishAndAmountToOrderList(dish,piecesOrdered);
        }
        ModelAndView mav =new ModelAndView("result");
        orders.add(order);
        mav.addObject("orders", orders);

        for (Order o: orders)
        {
            System.out.println(o.getClient().getName());
            System.out.println(o.getOrders());
        }
        return mav;
    }
}