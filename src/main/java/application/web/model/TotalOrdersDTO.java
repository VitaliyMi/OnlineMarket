package application.web.model;

import application.model.Dish;
import application.model.Order;
import application.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalOrdersDTO {

    private float totalSum;
    private float userTotalSum;
    private int totalDishesOrdered;
    private int[] numberOfDishesOrdered;
    private List<Order> orderList;
    private Map<String, Integer> totalNumberOfEachDishOrdered;
    private Map<String, Integer> totalClientOrderPrice;

    public TotalOrdersDTO(List<Order> orderList) {
        this.orderList = orderList;

    }
    
    public TotalOrdersDTO(List<Order> orderList, Map<String, Integer> totalNumberOfEachDishOrdered, Map<String, Integer> totalClientOrderPrice) {
        this.orderList = orderList;
        this.totalNumberOfEachDishOrdered = totalNumberOfEachDishOrdered;
        this.totalClientOrderPrice = totalClientOrderPrice;
        System.out.println(this.totalClientOrderPrice);

    }

    public TotalOrdersDTO(int[] numberOfDishesOrdered, int totalDishesOrdered, int totalSum) {
        this.numberOfDishesOrdered = numberOfDishesOrdered;
        this.totalDishesOrdered = totalDishesOrdered;
        this.totalSum = totalSum;
    }

    public float getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(float totalSum) {
        this.totalSum = totalSum;
    }

    public float getUserTotalSum() {
        return userTotalSum;
    }

    public void setUserTotalSum(float userTotalSum) {
        this.userTotalSum = userTotalSum;
    }

    public int getTotalDishesOrdered() {
        return totalDishesOrdered;
    }

    public void setTotalDishesOrdered(int totalDishesOrdered) {
        this.totalDishesOrdered = totalDishesOrdered;
    }

    public int[] getNumberOfDishesOrdered() {
        return numberOfDishesOrdered;
    }

    public void setNumberOfDishesOrdered(int[] numberOfDishesOrdered) {
        this.numberOfDishesOrdered = numberOfDishesOrdered;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Map<String, Integer> getTotalNumberOfEachDishOrdered() {
        return totalNumberOfEachDishOrdered;
    }

    public void setTotalNumberOfEachDishOrdered(Map<String, Integer> totalNumberOfEachDishOrdered) {
        this.totalNumberOfEachDishOrdered = totalNumberOfEachDishOrdered;
    }

    public Map<String, Integer> getTotalClientOrderPrice() {
        return totalClientOrderPrice;
    }

    public void setTotalClientOrderPrice(Map<String, Integer> totalClientOrderPrice) {
        this.totalClientOrderPrice = totalClientOrderPrice;
    }
}
