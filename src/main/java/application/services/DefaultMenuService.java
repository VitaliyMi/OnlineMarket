package application.services;

import application.exceptions.NothingSelectedException;
import application.model.Client;
import application.model.Dish;
import application.model.Order;
import application.repositories.DishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("service")
public class DefaultMenuService implements MenuService {

    private DishesRepository repository;


    @Autowired
    public DefaultMenuService(DishesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Dish> getMenu() {
        return repository.findAll();
    }

    @Override
    public Dish findByName(String name) {
        return repository.findByDishNameIgnoreCase(name);

    }

    public List<Dish> performSortedSearch(Optional<String> sorter) {
        if ("price".equals(sorter)) {
            return repository.findAllByOrderByPriceAsc();
        }
        if ("description".equals(sorter)) {
            return repository.findAllByOrderByDishNameAsc();
        }
        return new ArrayList<>();
    }

    public Order getOrderInformation(HttpServletRequest requestWithOrderInformation, Client client) {
        Order order = new Order(client);
        String[] orderedDishesNames = requestWithOrderInformation.getParameterValues("selected");
        if(orderedDishesNames==null) throw new NothingSelectedException();
        for (String s : orderedDishesNames) {
            Dish dish = repository.findByDishNameIgnoreCase(s);
            int piecesOrdered = Integer.parseInt(requestWithOrderInformation.getParameter("numberof" + s));
            order.addDishAndAmountToOrderList(dish, piecesOrdered);
        }
        return order;
    }

}
