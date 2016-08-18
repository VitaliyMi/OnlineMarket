package application; /**
 * Created by MSI on 20.04.2016.
 */
import model.comparators.ComparatorFactory;
import model.entities.Client;
import model.entities.Dish;
import model.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/")
@SessionAttributes(types = Client.class)
@Component("mainController")
public class MainController {

    private static List<Order> orders = new ArrayList<>();

    @Autowired
    Service service;

    @Autowired
    ResultUtil resultUtil;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printWelcome() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("client", new Client());
        return mav;
    }


    @RequestMapping("/showMenu")
    public ModelAndView requestHandlingMethod(HttpServletRequest request, @ModelAttribute Client client) {
        String sorter = request.getParameter("sorter");
        Comparator<Dish> comparator = ComparatorFactory.buildComparator(sorter);
        List<Dish> menu = service.getMenu();
        if (comparator != null) {
            Collections.sort(menu, comparator);
        }
        ModelAndView model = new ModelAndView("menulist");
        model.addObject("menuList", menu);
        return model;
    }


    @RequestMapping(value = "/viewCart")
    public ModelAndView showCart(HttpServletRequest request,@ModelAttribute Client client) {
        Order order = getOrderInformation(request, client);
        ModelAndView mav = new ModelAndView("cart");
        mav.addObject(order);
        request.getSession().setAttribute("order", order);
        return mav;
    }

   @RequestMapping(value = "/prosesOrder")
    public String prosesOrder(@ModelAttribute Client client, HttpServletRequest request)
    {
        Order order = (Order) request.getSession().getAttribute("order");
        orders.add(order);
        return "thanks";

    }


    @RequestMapping(value = "/showResult")
    public ModelAndView showResult(HttpSession session, @ModelAttribute Client client)
    {
        ModelAndView mav =new ModelAndView("result");
        String resultTable = resultUtil.getResultHTML(orders);
        mav.addObject("resultTable", resultTable);
        return mav;
    }

    private Order getOrderInformation(HttpServletRequest requestWithOrderInformation, Client client)
    {
        Order order= new Order(client);
        String[] orderedDishesNames = requestWithOrderInformation.getParameterValues("selected");

        for (String s : orderedDishesNames) {
            Dish dish = service.findByName(s);
            System.out.println(dish.getName() + "\t " + dish.getPrice());
            int piecesOrdered = Integer.parseInt(requestWithOrderInformation.getParameter("numberof" + s));
            order.addDishAndAmountToOrderList(dish, piecesOrdered);
        }
        return order;
    }


}