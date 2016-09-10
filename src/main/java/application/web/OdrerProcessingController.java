package application.web;

import application.model.Client;
import application.model.Order;
import application.services.DefaultMenuService;
import application.services.OrderProcessingService;
import application.web.model.TotalOrdersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI on 09.09.2016.
 */
@Controller
@SessionAttributes(types = Client.class)
public class OdrerProcessingController {
    private List<Order> orders = new ArrayList<>();


    @Autowired
    DefaultMenuService service;

    @Autowired
    OrderProcessingService orderService;

    @RequestMapping(value = "/processOrder")
    public String prosesOrder(@ModelAttribute Client client, HttpServletRequest request) {
        Order order = (Order) request.getSession().getAttribute("order");
        orderService.saveOrder(order);
        orders.add(order);
        return "thanks";

    }


    @RequestMapping(value = "/showResult")
    public ModelAndView showResult(HttpSession session, @ModelAttribute Client client) {
        ModelAndView mav = new ModelAndView("result");

        TotalOrdersDTO totalOrdersDTO = orderService.getOrderInformationForView(orderService.getAllOrders());
        mav.addObject("totalOrdersDTO", totalOrdersDTO);
        return mav;
    }
}
