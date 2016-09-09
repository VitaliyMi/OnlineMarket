package application.services;


import application.model.Order;
import application.web.model.TotalOrdersDTO;

import java.util.List;

public interface OrderProcessingService {

    TotalOrdersDTO getOrderInformationForView(List<Order> orders);

    List<Order> getAllOrders();

    void  saveOrder(Order order);
}
