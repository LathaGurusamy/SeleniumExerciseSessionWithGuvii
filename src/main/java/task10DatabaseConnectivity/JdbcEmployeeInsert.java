package task10DatabaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcEmployeeInsert {
		    	    public static void main(String[] args) {
		    	        String jdbcURL = "jdbc:mysql://localhost:3306/w3schools_sample"; 
		    	        String username = "root"; 
		    	        String password = "lathag"; 

		    	        String insertQuery = "INSERT INTO Employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

		    	        Object[][] employeeData = {
		    	            {101, "Jenny", 25, 10000.00},
		    	            {102, "Jacky", 30, 20000.00},
		    	            {103, "Joe", 20, 40000.00},
		    	            {104, "John", 40, 80000.00},
		    	            {105, "Shameer", 25, 90000.00}
		    	        };

		    	        try (
		    	            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
		    	            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)
		    	        ) {
		    	            for (Object[] employee : employeeData) {
		    	                preparedStatement.setInt(1, (int) employee[0]); // empcode
		    	                preparedStatement.setString(2, (String) employee[1]); // empname
		    	                preparedStatement.setInt(3, (int) employee[2]); // empage
		    	                preparedStatement.setDouble(4, (double) employee[3]); // esalary

		    	                preparedStatement.executeUpdate();
		    	            }

		    	            System.out.println("Data inserted successfully!");

		    	        } catch (Exception e) {
		    	            e.printStackTrace();
		    	        }
		    	    }
		    	}
