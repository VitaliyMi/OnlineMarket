package application.web;

import application.model.Dish;
import application.model.Order;
import application.services.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by MSI on 03.09.2016.
 */
public class ResultDTO {

    @Autowired
    Service service;

    public int[] getInitialData(List<Order> orders)
    {
        List<Dish> dishes = service.getMenu();
        List<String> dishNames = new ArrayList<>();
        int totalSum=0;
        int userTotalSum=0;
        int totalDishesOrdered=0;
        int []numberOfDishesOrdered;

        for(Order o: orders)
        {
            for(Map.Entry<Dish, Integer> entry: o.getDishes().entrySet())
            {
                totalSum+=entry.getKey().getPrice()*entry.getValue();
                totalDishesOrdered+=entry.getValue();
            }
        }

        numberOfDishesOrdered = new int [dishNames.size()];
        for(Order order: orders)
        {
            order.getClient().getName();
            for(int i=0; i<dishNames.size();i++)
        {
            if(!order.getDishes().containsKey(service.findByName(dishNames.get(i))))
            {

            }
            else

            {
                Dish currentDish = service.findByName(dishNames.get(i));
                order.getDishes().get(currentDish);
                userTotalSum+=currentDish.getPrice()*order.getDishes().get(currentDish);
                numberOfDishesOrdered[i]+=order.getDishes().get(currentDish);
            }
        }
            totalSum+=userTotalSum;
       //     userTotalSum

        }
        for(int j=0; j<numberOfDishesOrdered.length;j++)
        {
      //      numberOfDishesOrdered[j];
            totalDishesOrdered+=numberOfDishesOrdered[j];
        }
     //   totalDishesOrdered+" / "+totalSum
        int[] result = {totalSum, totalDishesOrdered};
        return result;
    }
}
