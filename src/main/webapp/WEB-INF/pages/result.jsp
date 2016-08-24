<%@ page import="application.model.entities.Order" %>
<%@ page import="application.model.entities.Dish" %>
<%@ page import="application.services.DishService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
<%@ page import="application.model.entities.Order" %>
  Created by IntelliJ IDEA.
  User: MSI
  Date: 20.07.2016
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>
  <head>
    <title>Online Market</title>
  </head>
  <body>
  <div class="container">
    <h3>Your order has been processed</h3>

    <table>
    <th>User</th>
      <%
        List<Order> orders = (List<Order>)request.getAttribute("orders");
        DishService service = (DishService) request.getAttribute("service");
        List<Dish> dishes = service.getMenu();
        List<String> dishNames = new ArrayList<>();
        int totalSum=0;
        int userTotalSum=0;
        int totalDishesOrdered=0;
        int []numberOfDishesOrdered;

        for(Dish d: dishes)
        {
      %>
      <th>
      <%=d.getName()%>
      <%dishNames.add(d.getName());%>

      </th>
      <%}
        numberOfDishesOrdered = new int [dishNames.size()];
        for(Order order: orders)
        {
          %><tr>
                <td><%=order.getClient().getName()%></td>
          <%for(int i=0; i<dishNames.size();i++)
          {

            if(!order.getDishes().containsKey(service.findByName(dishNames.get(i))))
            {
              %><td>0</td><%
            }
            else

            {
              Dish currentDish = service.findByName(dishNames.get(i));%>
              <td><%=order.getDishes().get(currentDish)%></td>
             <% userTotalSum+=currentDish.getPrice()*order.getDishes().get(currentDish);
              numberOfDishesOrdered[i]+=order.getDishes().get(currentDish);
            }
          }
          totalSum+=userTotalSum;%>
          <td><%=userTotalSum%></td></tr>
        <%
          }
        %>
      <tr><td>Total</td>
      <%
        for(int j=0; j<numberOfDishesOrdered.length;j++)
        {
      %><td><%=numberOfDishesOrdered[j]%></td>
      <%totalDishesOrdered+=numberOfDishesOrdered[j];
      }
      %><td><%=totalDishesOrdered+" / "+totalSum%></td></tr>
    </table>
      <input type="submit" value="View cart">
  </div>
  </body>
  </html>