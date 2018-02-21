package models;

/**
 * Import all the necessary packages used in this class
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * This Database Connector class creates an instance 
 * to create and get the connection from  specified server
 * @author Ajay Kumar Mukhi
 */
public class ConnectDB {
    
	
	/**
	 * Credentials used to connect MySQL localhost Server
	 */
	
      static String db_url = "jdbc:mysql://localhost:3306/test";
      static String user = "root";
      static String pass = "pass";
    
    	
	
	//Method getConnection to register the driver and 
    public static Connection getConnection(){
    	
    	Connection conn = null;
        try {
        	
        	//Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver"); //for mySQL DB
        	//Class.forName("oracle.jdbc.driver.OracleDriver"); //for Oracle DB
          
            //calling the getConnection method to establish the connection
        	conn=getConnection(db_url,user,pass);
        	
        	       
        } catch (ClassNotFoundException e) {
           // throw new IllegalArgumentException("Oracle db driver is not present in package");
        	throw new IllegalArgumentException("MySql db driver is not on present in package");
       } catch (SQLException e) {
			e.printStackTrace();
	   }
        
        return conn;
   }
    
    //method getConnection() taking the input parameters to make DB connection 
    public static Connection getConnection(String db_url,String username,String password) throws SQLException
    {
    	
        System.out.println("Connecting to a selected database...");        
    	return DriverManager.getConnection(db_url,username,password);
    } 
    
    
    public static void main(String args[]) {
		
    	//DaoModel dao = new DaoModel();
    	//dao.getResultSet();
        //System.out.println("Connected");
  		
  		
  	}
    
    
      
}
