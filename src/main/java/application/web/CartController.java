package application.web;

import application.exceptions.NothingSelectedException;
import application.model.Client;
import application.model.Dish;
import application.model.Order;
import application.services.DefaultMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by MSI on 09.09.2016.
 */
@Controller
@SessionAttributes(types = Client.class)
public class CartController {

    @Autowired
    DefaultMenuService service;

    @RequestMapping(value = "/viewCart")
    public ModelAndView showCart(HttpServletRequest request, @ModelAttribute Client client) {
        ModelAndView mav = new ModelAndView("cart");
        Order order = service.getOrderInformation(request, (Client) request.getSession().getAttribute("client"));
        mav.addObject(order);
        request.getSession().setAttribute("order", order);

        return mav;
    }

    @ExceptionHandler(NothingSelectedException.class)
    public ModelAndView handleNothingSelectedException(NothingSelectedException ex) {
        ModelAndView mav = new ModelAndView("menulist");
        mav.addObject("message", ex.getMessage());
        List<Dish> menu = service.getMenu();
        mav.addObject("menuList", menu);

        return mav;

    }
}