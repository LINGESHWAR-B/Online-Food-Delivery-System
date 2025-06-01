package com.examly.service;
import com.examly.entity.*;
import java.util.*;

public interface OrderService{
    boolean createOrder(Order order, List<OrderItem> orderedItems);
    List<Order> getOrderByCustomer(int customerId);
    Order getOrderById(int orderId);
}
