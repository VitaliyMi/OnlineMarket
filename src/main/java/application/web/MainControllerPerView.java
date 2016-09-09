package application.web;

import application.exceptions.NothingSelectedException;
import application.services.DefaultMenuService;
import application.model.Client;
import application.model.Dish;
import application.model.Order;
import application.services.OrderProcessingService;
import application.web.model.TotalOrdersDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/")
@SessionAttributes(types = Client.class)
public class MainControllerPerView {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static List<Order> orders = new ArrayList<>();

    @Autowired
    DefaultMenuService service;

    @Autowired
    OrderProcessingService orderServise;


    /* WTF */
    @RequestMapping("/")
    public ModelAndView printWelcome() {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("client", new Client());
        return mav;
    }


    @RequestMapping("/showMenu")
    public ModelAndView requestHandlingMethod(HttpServletRequest request, @ModelAttribute Client client) {
        Optional<String> sorter = null;
        sorter = Optional.ofNullable(request.getParameter("sorter"));

        List<Dish> menu;
        if (sorter.isPresent()) {
            menu = service.performSortedSearch(sorter.get());
        } else {
            menu = service.getMenu();
        }

        ModelAndView model = new ModelAndView("menulist");
        model.addObject("menuList", menu);
        return model;
    }


    @RequestMapping(value = "/viewCart")
    public ModelAndView showCart(HttpServletRequest request, @ModelAttribute Client client) {

        ModelAndView mav = new ModelAndView("cart");
        try {
            Order order = service.getOrderInformation(request, client);
            mav.addObject(order);
            request.getSession().setAttribute("order", order);

        } catch (NothingSelectedException e) {
            mav.setViewName("menulist");
            mav.addObject("message", e.getMessage());
            List<Dish> menu = service.getMenu();
            mav.addObject("menuList", menu);
        }
        return mav;
    }

    @RequestMapping(value = "/prosesOrder")
    public String prosesOrder(@ModelAttribute Client client, HttpServletRequest request) {
        Order order = (Order) request.getSession().getAttribute("order");
        orderServise.saveOrder(order);
        orders.add(order);
        return "thanks";

    }


    @RequestMapping(value = "/showResult")
    public ModelAndView showResult(HttpSession session, @ModelAttribute Client client) {
        ModelAndView mav = new ModelAndView("result");
        mav.addObject("service", service);
        TotalOrdersDTO totalOrdersDTO = orderServise.getOrderInformationForView(orders);
        mav.addObject("orders", orders);
        mav.addObject("totalOrdersDTO", totalOrdersDTO);
        return mav;
    }

    //todo how to process this information(using request) in service


    @Override
    protected void finalize() throws Throwable {
        logger.warn("Controller is closed");
    }
}