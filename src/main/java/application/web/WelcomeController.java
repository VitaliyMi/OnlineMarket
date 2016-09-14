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
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DefaultMenuService service;

    @Autowired
    OrderProcessingService orderServise;

    @RequestMapping("/")
    public ModelAndView printWelcome() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("client", new Client());
        return mav;
    }


    @Override
    protected void finalize() throws Throwable {
        logger.warn("Controller is closed");
    }
}