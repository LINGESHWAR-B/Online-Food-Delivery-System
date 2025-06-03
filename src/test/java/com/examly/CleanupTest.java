package com.examly;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.*;

public class CleanupTest {
    @BeforeAll
    public static void cleanTestCustomer(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/appdb", "root", "examly");
            String delete = "delete from customer where email = ?";
            PreparedStatement ps = conn.prepareStatement(delete);
            ps.setString(1, "john.doe@example.com");
            int r = ps.executeUpdate();

            System.out.println("CleanupTest: Deleted " + r + " existing John Doe records");
            ps.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println("CleanupTest: Error while cleaning up the test customer - " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void dummyTest(){
        System.out.println("CleanupTest: Cleanup executed before AppTest.");
    }
}