package application.services;

import application.model.Dish;
import application.model.Order;
import application.repositories.DishesRepository;
import application.web.model.TotalOrdersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("orderService")
public class DefaultOrderProcessingService implements OrderProcessingService {


    List<Order> orders = new ArrayList<>();
    private DishesRepository repository;
    @Autowired
    public DefaultOrderProcessingService(DishesRepository repository) {
        this.repository = repository;
    }

    @Override
    public TotalOrdersDTO getOrderInformationForView(List<Order> orders) {

        TotalOrdersDTO totalOrdersDTO = new TotalOrdersDTO(orders, initilizeTotalDishToAmountMap(),initializeTotalClientOrderPriceMap());

        int userTotalSum = 0;
        for (Order o : orders) {
            userTotalSum=0;
            for (Map.Entry<Dish, Integer> entry : o.getDishes().entrySet()) {
                totalOrdersDTO.setTotalSum(totalOrdersDTO.getTotalSum() + entry.getKey().getPrice() * entry.getValue());
                totalOrdersDTO.setTotalDishesOrdered(totalOrdersDTO.getTotalDishesOrdered() + entry.getValue());
                userTotalSum+=entry.getValue();
                Map<String, Integer> totalNumberOfEachDishOrdered= totalOrdersDTO.getTotalNumberOfEachDishOrdered();
                totalNumberOfEachDishOrdered.put(entry.getKey().getName(), totalNumberOfEachDishOrdered.get(entry.getKey().getName())+entry.getValue());
                System.out.println(totalNumberOfEachDishOrdered);
            }

        }

        return totalOrdersDTO;
    }

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }

    @Override
    public void saveOrder(Order order) {
        orders.add(order);
        repository.findAll();
    }

    Map<String, Integer> initilizeTotalDishToAmountMap() {
        Map<String, Integer> dishNameIntegerMap=new HashMap<>();
        List<Dish> dishes=repository.findAll();

        for(Dish d: dishes)
        {
            dishNameIntegerMap.put(d.getName(),0);
        }
        return dishNameIntegerMap;
    }

    Map<String, Integer> initializeTotalClientOrderPriceMap()
    {
        Map<String, Integer> clientOrderMap= new HashMap<>();
        for(Order o:orders)
        {
            int totalClientSum=0;
            for(Map.Entry<Dish, Integer> d: o.getDishes().entrySet())
            {
              totalClientSum+=d.getValue()*d.getKey().getPrice();
            }
            clientOrderMap.put(o.getClient().getName(), totalClientSum);
        }
        return clientOrderMap;
    }
}

