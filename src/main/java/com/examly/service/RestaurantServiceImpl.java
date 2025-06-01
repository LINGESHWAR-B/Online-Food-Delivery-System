package com.examly.service;
import com.examly.entity.Restaurant;
import com.examly.util.*;
import java.sql.*;
import java.util.*;

public class RestaurantServiceImpl implements RestaurantService{
    @Override
    public boolean createRestaurant(Restaurant restaurant){
        try{
            String insert = "INSERT INTO restaurant (name, address, cuisineType, contactNumber) VALUES (?, ?, ?, ?)";
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement ips = conn.prepareStatement(insert);
            ips.setString(1, restaurant.getName());
            ips.setString(2, restaurant.getAddress());
            ips.setString(3, restaurant.getCuisineType());
            ips.setString(4, restaurant.getContactNumber());

            return ips.executeUpdate() > 0;
        }

        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants(){
        List<Restaurant> restaurants = new ArrayList<>();
        try{
            String select = "select * from restaurant;";
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Restaurant obj = new Restaurant(rs.getInt("restaurantId"), rs.getString("name"), rs.getString("address"), rs.getString("cuisineType"), rs.getString("contactNumber"));
                restaurants.add(obj);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return restaurants;
    }
}
