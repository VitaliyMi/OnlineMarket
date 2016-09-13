package application.web;

import application.model.Client;
import application.model.Dish;
import application.services.DefaultMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * Created by MSI on 09.09.2016.
 */
@Controller
@SessionAttributes(types = Client.class)
public class MenuController {

    @Autowired
    DefaultMenuService service;

    @RequestMapping("/showMenu")
    public ModelAndView requestHandlingMethod(HttpServletRequest request, @ModelAttribute Client client) {
        Optional<String> sorter = null;
        sorter = Optional.ofNullable(request.getParameter("sorter"));

        List<Dish> menu;
        if (sorter.isPresent()) {
            menu = service.performSortedSearch(sorter);
        } else {
            menu = service.getMenu();
        }

        ModelAndView model = new ModelAndView("menulist");
        model.addObject("menuList", menu);
        return model;
    }


}
