package application;

import model.entities.Dish;
import model.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI on 01.08.2016.
 */
@Component("resultUtil")
public class ResultUtil {

    @Autowired
    Service service;
    public  String getResultHTML(List<Order> orders)
    {
        int totalSum=0;
        StringBuilder resultString = new StringBuilder();
        List<String> dishNames =getDishesNames();
        int[] numberOfDishesOrdered= new int[getDishesNames().size()];

        resultString.append("<table><th>User</th>");

        for(int i =0; i<dishNames.size(); i++)
        {
            resultString.append("<th>"+dishNames.get(i)+"</th>");
        }
        resultString.append("<th>Sum</th>");
        int userTotalSum;

        for(Order order: orders)
        {
           userTotalSum=0;
            resultString.append("<tr><td>"+order.getClient().getName()+"</td>");
            for(int i=0; i<dishNames.size();i++)
            {

                if(!order.getDishes().containsKey(service.findByName(dishNames.get(i))))
                {
                    resultString.append("<td>"+0+"</td>");
                }
                else
                {
                    Dish currentDish = service.findByName(dishNames.get(i));
                    resultString.append("<td>"+order.getDishes().get(currentDish)+"</td>");
                    userTotalSum+=currentDish.getPrice()*order.getDishes().get(currentDish);
                    numberOfDishesOrdered[i]+=order.getDishes().get(currentDish);
                }
            }
            totalSum+=userTotalSum;
            resultString.append("<td> "+userTotalSum+"$</td></tr>");

        }

        int totalDishesOrdered=0;
        resultString.append("<tr><td>Total</td>");
        for(int i=0; i<numberOfDishesOrdered.length;i++)
        {
            resultString.append("<td>"+numberOfDishesOrdered[i]+"</td>");
            totalDishesOrdered+=numberOfDishesOrdered[i];
        }

        resultString.append("<td>"+totalDishesOrdered+" / "+totalSum+"$</td></tr></table>");
        return resultString.toString();
    }

    public  List<String> getDishesNames()
    {
        List<Dish> menu =service.getMenu();
        List<String> dishnames= new ArrayList<>();
        for(Dish d: menu)
        {
            dishnames.add(d.getName());
        }
        return dishnames;
    }
}
