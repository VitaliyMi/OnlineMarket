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

    private StringBuilder resultString = new StringBuilder();
    private int userTotalSum;
    private List<String> dishNames;
    int totalSum=0;
    int[] numberOfDishesOrdered;
    int totalDishesOrdered=0;


    @Autowired
    Service service;

    public  String getResultHTML(List<Order> orders)
    {
        resetData();
        addHeadersToResultTable();
        fillTableWithData(orders);
        addTableSummary();
        return getResultTable();
    }

    private List<String> getDishesNames()
    {
        List<Dish> menu =service.getMenu();
        List<String> dishnames= new ArrayList<>();
        for(Dish d: menu)
        {
            dishnames.add(d.getName());
        }
        return dishnames;
    }


    private void addHeadersToResultTable()
    {

        resultString.append("<table><th>User</th>");

        for(int i =0; i<dishNames.size(); i++)
        {
            resultString.append("<th>"+dishNames.get(i)+"</th>");
        }
        resultString.append("<th>Sum</th>");

    }


    private void fillTableWithData(List<Order> orders)
    {
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
    }

    private void addTableSummary()
    {
        resultString.append("<tr><td>Total</td>");
        for(int i=0; i<numberOfDishesOrdered.length;i++)
        {
            resultString.append("<td>"+numberOfDishesOrdered[i]+"</td>");
            totalDishesOrdered+=numberOfDishesOrdered[i];
        }

        resultString.append("<td>"+totalDishesOrdered+" / "+totalSum+"$</td></tr></table>");
    }

    private void resetData()
    {
        resultString=new StringBuilder();
        dishNames = getDishesNames();
        numberOfDishesOrdered = new int[getDishesNames().size()];
        userTotalSum = 0;
        totalSum=0;
        totalDishesOrdered=0;
    }




    private String getResultTable()
    {
       return resultString.toString();
    }
}
