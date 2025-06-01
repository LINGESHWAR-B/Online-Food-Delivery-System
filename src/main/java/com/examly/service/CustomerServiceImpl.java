package com.examly.service;
import com.examly.entity.*;
import com.examly.exception.*;
import com.examly.util.*;
import java.sql.*;

public class CustomerServiceImpl implements CustomerService{
    public boolean createCustomer(Customer customer) throws EmailAlreadyRegisteredException{
        String email = "select count(*) from customer where email = ?";
        String insert = "INSERT INTO customer (name, email, phoneNumber, password) VALUES (?, ?, ?, ?)";
        try{
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(email);
            ps.setString(1, customer.getEmail());
            ResultSet rs = ps.executeQuery();

            if(rs.next() && rs.getInt(1) > 0){
                throw new EmailAlreadyRegisteredException("Email " + customer.getEmail() + " is already registered");
            }

            PreparedStatement ips = conn.prepareStatement(insert);
            ips.setString(1, customer.getName());
            ips.setString(2, customer.getEmail());
            ips.setString(3, customer.getPhone());
            ips.setString(4, customer.getPass());

            return ips.executeUpdate() > 0;
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
