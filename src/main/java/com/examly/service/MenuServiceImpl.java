package com.examly.service;
import com.examly.entity.*;
import com.examly.exception.*;
import com.examly.util.*;
import java.sql.*;
import java.util.*;

public class MenuServiceImpl implements MenuService{
    @Override
    public boolean createMenuItem(MenuItem menu) throws RestaurantNotFoundException{
        try{
            String check = "select count(*) from restaurant where restaurantId = ?";
            String insert = "INSERT INTO menuItem (restaurantId, name, price, description, availableQuantity) VALUES (?, ?, ?, ?, ?)";
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(check);
            ps.setInt(1, menu.getRestaurantId());
            ResultSet rs = ps.executeQuery();
            if(rs.next() && rs.getInt(1) == 0){
                throw new RestaurantNotFoundException("Restaurant with id " + menu.getRestaurantId() + " not found");
            }

            PreparedStatement ips = conn.prepareStatement(insert);
            ips.setInt(1, menu.getRestaurantId());
            ips.setString(2, menu.getName());
            ips.setDouble(3, menu.getPrice());
            ips.setString(4, menu.getDescription());
            ips.setInt(5, menu.getAvailable());

            return ips.executeUpdate() > 0;
        }

        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<MenuItem> getMenuItemsByRestaurant(int restaurantId){
        List<MenuItem> menuItem = new ArrayList<>();
        try{
            String select = "select * from menuItem where restaurantId = ?;";
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(select);
            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                MenuItem item = new MenuItem(rs.getInt("restaurantId"), rs.getString("name"), rs.getDouble("price"), rs.getString("description"), rs.getInt("availableQuantity"));
                menuItem.add(item);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return menuItem;
    }
}
