package com.examly.service;
import com.examly.entity.*;
import java.util.*;
import java.sql.*;
import com.examly.util.*;

public class OrderServiceImpl implements OrderService{
    public boolean createOrder(Order order, List<OrderItem> orderedItems){
        try{
            String insert1 = "insert into `order` (customerId, restaurantId, orderStatus, totalPrice, deliveryAddress) values(?,?,?,?,?);";
            String insert2 = "INSERT INTO orderItem (orderId, itemId, quantity) VALUES (?, ?, ?)";

            Connection conn = DBConnectionUtil.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(insert1, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getCustomerId());
            ps.setInt(2, order.getRestaurantId());
            ps.setString(3, order.getOrderStatus());
            ps.setDouble(4, order.getTotalPrice());
            ps.setString(5, order.getDeliveryAddress());
            int r1 = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int orderId = -1;
            if(rs.next()){
                orderId = rs.getInt(1);
            }

            PreparedStatement ps2 = conn.prepareStatement(insert2);
            ps2.setInt(1, orderId);
            for(OrderItem obj : orderedItems){
                ps2.setInt(2, obj.getItemId());
                ps2.setInt(3, obj.getQuantity());
                ps.addBatch();
            }
            int[] r2 = ps2.executeBatch();
            conn.commit();
            return r1 > 0 && r2.length == orderedItems.size();
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Order> getOrderByCustomer(int customerId){
        List<Order> item = new ArrayList<>();

        try{
            String select = "select * from `order` where customerId = ?;";
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Order ord = new Order(rs.getInt("customerId"), rs.getInt("restaurantId"), rs.getString("orderStatus"), rs.getDouble("totalPrice"), rs.getString("deliveryAddress"));
                item.add(ord);
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }

        return item;
    }

    public Order getOrderById(int orderId){
        Order order = null;

        try{
            String select = "select * from `order` where orderId = ?;";
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                order = new Order(rs.getInt("orderId"), rs.getInt("customerId"), rs.getInt("restaurantId"), rs.getString("orderStatus"), rs.getDouble("totalPrice"), rs.getString("deliveryAddress"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return order;
    }
}