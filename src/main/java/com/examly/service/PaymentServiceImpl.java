package com.examly.service;
import java.sql.*;
import com.examly.entity.*;
import com.examly.util.*;

public class PaymentServiceImpl implements PaymentService{
    @Override
    public boolean processPayment(Payment payment){
        try{
            String insert = "insert into payment values(?,?,?,?,?);";
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(insert);

            ps.setInt(1, payment.getPaymentId());
            ps.setInt(2, payment.getOrderId());
            ps.setTimestamp(3, new Timestamp(payment.getPaymentDate().getTime()));
            ps.setString(4,payment.getPaymentStatus());
            ps.setDouble(5, payment.getAmountPaid());

            return ps.executeUpdate() > 0;
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}