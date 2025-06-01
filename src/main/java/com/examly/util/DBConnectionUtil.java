package com.examly.util;
import java.sql.*;

public class DBConnectionUtil {
    public static Connection getConnection() throws SQLException{
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/appdb", "root", "examly");
        }
        catch(Exception e){
            throw new SQLException(e);
        }
    }
}
