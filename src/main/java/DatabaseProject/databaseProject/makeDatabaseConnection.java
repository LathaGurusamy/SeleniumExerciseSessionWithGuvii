package DatabaseProject.databaseProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class makeDatabaseConnection {

	public static void main(String[] args) throws SQLException 
	{
	  String url = "jdbc:mysql://localhost:3306/w3schools_sample";
	  String username = "root";
	  String password = "lathag";
      Connection connection=DriverManager.getConnection(url,username,password);
      Statement statement = connection.createStatement();
      String myQuery = "Select ProductID, ProductName from Products";
      ResultSet result = statement.executeQuery(myQuery);
      
      while(result.next()) {
    	  int productID = result.getInt("ProductID");
    	  String productName = result.getString("ProductName");
    	  System.out.println("product Id and product name are :: " + productID + "  " + productName);
    	  
    	  System.out.println("From front end I am exepcting the productName is :: Apple");
    	  if(productName.equalsIgnoreCase("Apple")) {
    		  System.out.println("Correct Entry is there inn the database");
    	  }
    	  else {
    		  System.out.println("Not a correct entry");
    	  }
      }
      
      

	}


}
