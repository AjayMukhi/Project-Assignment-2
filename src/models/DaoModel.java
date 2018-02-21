package models;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * This DaoModel class creates 3 methods createTable(), inserts() 
   and getResultSet() to do the necesaary CRUD operation
 * @author Ajay Kumar Mukhi
 */
public class DaoModel {
    
	   
	   
	  //Method to check whether the table is exits
	   private boolean tableExists(Connection conn, String tableName) throws SQLException {
	    
		boolean tableExists = false;	    	
	    DatabaseMetaData dbmd = conn.getMetaData();	    
	    ResultSet rs = dbmd.getTables(null, null, tableName, null);

	    while(rs.next()){
	    	
		    String tName = rs.getString("TABLE_NAME");
		    //System.out.println(tName);
		    if(tName!=null && tName.equalsIgnoreCase(tableName)){
	    	     System.out.println("TABLE_NAME: " + tName);
	    	     tableExists= true;
	    	     break;
		    }
	   }
	    	    
        return tableExists;   
	    
	 }
	   
	
	//createTable() creates id field, an income field and a pep field 
	public void createTable() {
		
		System.out.println("Creating table now...");
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			String tableName="BOOK";
			
			if(tableExists(conn,tableName)){
			   System.out.println("Table already Exists");	
			}
			else{			
				
			    System.out.println("Creating table in given database...");
				String sqlCreate = "CREATE TABLE "+tableName 
			            +" (id integer primary key auto_increment,"
			            +"  book_id varchar(25) not null unique,"
			            +"  author varchar(50) not null,"
			            +"  title varchar(250) not null,"	
			            +"  genre varchar(25) not null,"
			            +"  price float not null,"
			            +"  publish_date date not null,"			            		            
			            +"  description text not null )";
	            Statement stmt = conn.createStatement();
	            stmt.executeUpdate(sqlCreate);
		  
		        System.out.println("Table "+tableName +" is created successfully.");		  
		   
		   
			}
			conn.close();		    
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		System.out.println("------------------------------------------------");	
	 }
	
	//createTable() creates id field, an income field and a pep field 
	 public void createSupplierTable(String tableName) {
			
			System.out.println("Creating Supplier table now...");
			
			try {
				
				Connection conn = ConnectDB.getConnection();
				tableName="SUPPLIER";
				
				if(tableExists(conn,tableName)){
				   System.out.println("Table already Exists");	
				}
				else{			
					
				    System.out.println("Creating table in given database...");
					String sqlCreate = "CREATE TABLE "+tableName 
				            +" (id integer primary key auto_increment,"
				            +"  supplier_id varchar(25) not null unique,"
				            +"  name varchar(50) not null,"
				            +"  address1 varchar(250) not null,"
				            +"  address2 varchar(250) not null,"
				            +"  city varchar(25) not null,"
				            +"  zipcode varchar(25) not null,"
				            +"  state varchar(50) not null,"
				            +"  email varchar(50) not null,"				                       		            
				            +"  phone varchar(20) not null )";
		            Statement stmt = conn.createStatement();
		            stmt.executeUpdate(sqlCreate);
			  
			        System.out.println("Table "+tableName +" is created successfully.");		  
			   
			   
				}
				conn.close();		    
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			System.out.println("------------------------------------------------");	
		 }
	 
	 
	//createTable() creates id field, an name,address,phone number field 
		 public void createCustomerTable(String tableName) {
				
				System.out.println("Creating consumer table now...");
				
				try {
					
					Connection conn = ConnectDB.getConnection();
					tableName="CUSTOMER";
					
					if(tableExists(conn,tableName)){
					   System.out.println("Table already Exists");	
					}
					else{			
						
					    System.out.println("Creating table in given database...");
						String sqlCreate = "CREATE TABLE "+tableName 
					            +" (id integer primary key auto_increment,"
					            +"  customer_id varchar(25) not null unique,"
					            +"  name varchar(50) not null,"
					            +"  address1 varchar(250) not null,"
					            +"  address2 varchar(250) not null,"
					            +"  city varchar(25) not null,"
					            +"  zipcode varchar(25) not null,"
					            +"  state varchar(50) not null,"
					            +"  country varchar(50) not null,"
					            +"  email varchar(50) not null,"				                       		            
					            +"  phone varchar(20) not null )";
			            Statement stmt = conn.createStatement();
			            stmt.executeUpdate(sqlCreate);
				  
				        System.out.println("Table "+tableName +" is created successfully.");		  
				   
				   
					}
					conn.close();		    
						
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
				System.out.println("------------------------------------------------");	
			 }
		 
	  //createUserTable() creates id field, an user id field and a password field 
	  public void createUserTable(String tableName) {
				
				System.out.println("Creating User table now...");
				
				try {
					
					Connection conn = ConnectDB.getConnection();
					tableName="USER";
					
					if(tableExists(conn,tableName)){
					   System.out.println("Table already Exists");	
					}
					else{			
						
					    System.out.println("Creating table in given database...");
						String sqlCreate = "CREATE TABLE "+tableName 
					            +" (id integer primary key auto_increment,"
					            +"  user_id varchar(25) not null unique,"
					            +"  password varchar(50) not null,"
					            +"  email varchar(250) not null,"
					            +"  phone varchar(250) not null,"	
					            +"  usertype varchar(25) not null )";
			            Statement stmt = conn.createStatement();
			            stmt.executeUpdate(sqlCreate);
				  
				        System.out.println("Table "+tableName +" is created successfully.");		  
				   
				   
					}
					conn.close();		    
						
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
				System.out.println("------------------------------------------------");	
			 }
	  
	  
	  
	//createTable() creates id field, an income field and a pep field 
		 public void createPartsTable(String tableName) {
				
				System.out.println("Creating Parts table now...");
				
				try {
					
					Connection conn = ConnectDB.getConnection();
					tableName="PARTS";
					
					if(tableExists(conn,tableName)){
					   System.out.println("Table already Exists");	
					}
					else{			
						
					    System.out.println("Creating table in given database...");
						String sqlCreate = "CREATE TABLE "+tableName 
					            +" (id integer primary key auto_increment,"
					            +"  part_id varchar(25) not null unique,"
					            +"  name varchar(50) not null,"
					            +"  category varchar(250) not null,"
					            +"  model varchar(250) not null,"	
					            +"  price float not null,"
					            +"  supplier_id varchar(50) not null,"
					            +"  supplier_name varchar(50) not null"
					            + ")";
			            Statement stmt = conn.createStatement();
			            stmt.executeUpdate(sqlCreate);
				  
				        System.out.println("Table "+tableName +" is created successfully.");		  
				   
				   
					}
					conn.close();		    
						
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
				System.out.println("------------------------------------------------");	
			 }
		 
	
		 
		
		//createTable() creates id field, an income field and a pep field 
		 public void createCustomerOrderTable(String tableName) {
				
				System.out.println("Creating Customer Order table now...");
				
				try {
					
					Connection conn = ConnectDB.getConnection();
					tableName="CUSTOMERORDER";
					
					if(tableExists(conn,tableName)){
					   System.out.println("Table already Exists");	
					}
					else{			
						
					    System.out.println("Creating table in given database...");
						String sqlCreate = "CREATE TABLE "+tableName 
					            +" (id integer primary key auto_increment,"
					            +"  order_id varchar(25) not null unique,"
					            +"  item_name varchar(150) not null,"
					            +"  item_id  varchar(50) not null,"
					            +"  quantity int not null,"
					            +"  price  float not null,"
					            +"  customer_id varchar(25) not null,"
					            +"  customer_name varchar(50) not null,"
					            +"  phone varchar(25) not null,"
					            +"  payment_type varchar(25) not null,"
					            +"  payment_id varchar(25) not null,"
					            +"  order_date date not null,"
					            +"  address varchar(50) not null,"
					            +"  city varchar(25) not null,"
					            +"  state varchar(25) not null,"
					            +"  postalcode varchar(25) not null,"	
					            +"  country varchar(50) not null )";
			            Statement stmt = conn.createStatement();
			            stmt.executeUpdate(sqlCreate);
				  
				        System.out.println("Table "+tableName +" is created successfully.");		  
				   
				   
					}
					conn.close();		    
						
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
				System.out.println("------------------------------------------------");	
			 }
		
		 
		//createPaymentDetailsTable() creates payment id field, payment type field and billing address details field 
		 public void createPaymentDetailTable(String tableName) {
				
				System.out.println("Creating Customer Order table now...");
				
				try {
					
					Connection conn = ConnectDB.getConnection();
					tableName="PAYMENTDETAILS";
					
					if(tableExists(conn,tableName)){
					   System.out.println("Table already Exists");	
					}
					else{			
						
					    System.out.println("Creating table in given database...");
						String sqlCreate = "CREATE TABLE "+tableName 
					            +" (id integer primary key auto_increment,"
					            +"  payment_id varchar(25) not null unique,"
					            +"  payment_type varchar(50) not null,"
					            +"  card_number  varchar(50) not null,"
					            +"  card_type varchar(50) not null,"
					            +"  amount  float(10,2) not null,"
					            +"  payment_date date not null,"
					            +"  billing_address varchar(50) not null,"
					            +"  city varchar(25) not null,"
					            +"  state varchar(25) not null,"
					            +"  postalcode varchar(25) not null,"	
					            +"  country varchar(50) not null )";
					            
					            
			            Statement stmt = conn.createStatement();
			            stmt.executeUpdate(sqlCreate);
				  
				        System.out.println("Table "+tableName +" is created successfully.");		  
				   
				   
					}
					conn.close();		    
						
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
				System.out.println("------------------------------------------------");	
			 }
		
		 
			
	
		 
		 
	//Inserts() takes arrayList of books to insert into the database  
	public void inserts(List<String> list) {
		
		System.out.println("Inserting the array of records into table now...");
		String tableName="BOOK";
	    try {
			String sqlInsert = "INSERT INTO "+tableName
			 +"  (book_id ,"
			 +"   author ,"
			 +"    title,"
			 +"    genre, "
	         +"    price,"
			 +"    publish_date,"
			 +"   description )"
			 +" VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			Connection conn = ConnectDB.getConnection();
		    PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
		    
	    
			for(int i=0;i<list.size();i++){
				
				pstmt.setString(i+1, list.get(i));	    	
		    	
			   
		    }
			
			 pstmt.executeUpdate();	
		    
	   
			conn.close();
			
			
		  } catch(SQLIntegrityConstraintViolationException e){
			   System.out.println("Cannot insert duplicate Records...Unique key constraint");
		  }
		 
		  catch (SQLException e) {
			e.printStackTrace();
		  }
		 System.out.println("------------------------------------------------");		 
	 }
	 
	


	
	//Inserts() takes arrayList of Suppliers to insert into the database
	public void insertSupplier(List<String> list, String tableName) {
			
	     System.out.println("Inserting the array of supplier records into table now...");
	      		
	      tableName="SUPPLIER";
	      
		   try {
				String sqlInsert = "INSERT INTO "+tableName
				 +"  (supplier_id ,"
				 +"    name ,"
				 +"    address1,"
				 +"    address2, "
				 +"    city ,"
		         +"    zipcode,"
				 +"    state,"
		         +"    email,"
				 +"    phone )"
				 +" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				Connection conn = ConnectDB.getConnection();
			    PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			    
		    
				for(int i=0;i<list.size();i++){
					
					pstmt.setString(i+1, list.get(i));	    	
			    	
				   
			    }
				
				 pstmt.executeUpdate();	
			    
		   
				conn.close();
				
				
			  } catch(SQLIntegrityConstraintViolationException e){
				   System.out.println("Cannot insert duplicate Records...Unique key constraint");
			  }
			 
			  catch (SQLException e) {
				e.printStackTrace();
			  }
			 System.out.println("------------------------------------------------");		 
		 }
	//Inserts() takes arrayList of Customer to insert into the database  
	public void insertCustomer(List<String> list, String tableName) {
			
	       System.out.println("Inserting the array of consumer records into table now...");
			tableName="CUSTOMER";
		    try {
				String sqlInsert = "INSERT INTO "+tableName
				 +"  (customer_id ,"
				 +"    name ,"
				 +"    address1,"
				 +"    address2, "
				 +"    city ,"
		         +"    zipcode,"		         
				 +"    state,"
		         +"    country,"
		         +"    email,"
				 +"    phone )"
				 +" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				Connection conn = ConnectDB.getConnection();
			    PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			    
		    
				for(int i=0;i<list.size();i++){
					
					pstmt.setString(i+1, list.get(i));	    	
			    	
				   
			    }
				
				 pstmt.executeUpdate();	
			    
		   
				conn.close();
				
				
			  } catch(SQLIntegrityConstraintViolationException e){
				   System.out.println("Cannot insert duplicate Records...Unique key constraint");
			  }
			 
			  catch (SQLException e) {
				e.printStackTrace();
			  }
			 System.out.println("------------------------------------------------");		 
		 }	
	
	
	
	
	
	
	    //Inserts() takes arrayList of Users to insert into the database  
		public void insertUser(List<String> list,String tableName) {
				
		 System.out.println("Inserting the array of users records into table now...");
		 
		     tableName="USER";
				
			    try {
					String sqlInsert = "INSERT INTO "+tableName
					 +"  (user_id ,"
					 +"   password ,"
					 +"   email,"
					 +"   phone, "
			         +"   usertype )"
					 +" VALUES(?, ?, ?, ?, ?)";
					
					Connection conn = ConnectDB.getConnection();
				    PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
				    
			    
					for(int i=0;i<list.size();i++){
						
						pstmt.setString(i+1, list.get(i));	    	
				    	
					   
				    }
					
					 pstmt.executeUpdate();	
				    
			   
					conn.close();
					
					
				  } catch(SQLIntegrityConstraintViolationException e){
					   System.out.println("Cannot insert duplicate Records...Unique key constraint");
				  }
				 
				  catch (SQLException e) {
					e.printStackTrace();
				  }
				 System.out.println("------------------------------------------------");		 
			 }	
		
		
		//Inserts() takes arrayList of Parts to insert into the database
		public void insertParts(List<String> list, String tableName) {
				
		System.out.println("Inserting the array of parts records into table now...");
				
			    try {
					String sqlInsert = "INSERT INTO "+tableName
					 +"  (part_id ,"
					 +"    name ,"
					 +"    category,"
					 +"    model, "
			         +"    price,"
					 +"    supplier_id,"
			         +"    supplier_name"
			         + ")"
					 +" VALUES(?, ?, ?, ?, ?, ?, ?)";
					
					Connection conn = ConnectDB.getConnection();
				    PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
				    
			    
					for(int i=0;i<list.size();i++){
						
						pstmt.setString(i+1, list.get(i));	    	
				    	
					   
				    }
					
					 pstmt.executeUpdate();	
				    
			   
					conn.close();
					
					
				  } catch(SQLIntegrityConstraintViolationException e){
					   System.out.println("Cannot insert duplicate Records...Unique key constraint");
				  }
				 
				  catch (SQLException e) {
					e.printStackTrace();
				  }
				 System.out.println("------------------------------------------------");		 
			 
		}
	

		
		//Inserts() takes arrayList of CustomerOrder to insert into the database
		public void insertCustomerOrder(List<String> list,String tableName) {
						
				System.out.println("Inserting the array of parts records into table now...");
						tableName="CUSTOMERORDER";
					    try {
							String sqlInsert = "INSERT INTO "+tableName
							 +"  (order_id ,"							 
							 +"    item_name,"
							 +"    item_id ,"
							 +"    quantity, "	
							 +"    price, "
							 +"    customer_id,"
					         +"    customer_name,"
					         +"    phone,"
					         +"    payment_type,"
					         +"    payment_id,"
					         +"    order_date,"
					         +"    address,"
					         +"    city,"
					         +"    state,"
					         +"    postalcode,"
					         +"    country"  
							 +" )"
							 +" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
							
							Connection conn = ConnectDB.getConnection();
						    PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
						    
					    
							for(int i=0;i<list.size();i++){
								
								pstmt.setString(i+1, list.get(i));	    	
						    	
							   
						    }
							
							 pstmt.executeUpdate();	
						    
					   
							conn.close();
							
							
						  } catch(SQLIntegrityConstraintViolationException e){
							   System.out.println("Cannot insert duplicate Records...Unique key constraint");
						  }
						 
						  catch (SQLException e) {
							e.printStackTrace();
						  }
						 System.out.println("------------------------------------------------");		 
		}	
				
		
		
		//Inserts() takes arrayList of PaymentDetails to insert into the database
		public void insertPaymentDetails(List<String> list,String tableName) {
						
				System.out.println("Inserting the array of parts records into table now...");
						tableName="PAYMENTDETAILS";
					    try {
							String sqlInsert = "INSERT INTO "+tableName
							 +"  (payment_id ,"							 
							 +"    payment_type,"
							 +"    card_number ,"
							 +"    card_type, "	
							 +"    amount, "
							 +"    payment_date,"
					         +"    billing_address,"
					         +"    city,"
					         +"    state,"
					         +"    postalcode,"
					         +"    country"
					         +" )"
							 +" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
							
							Connection conn = ConnectDB.getConnection();
						    PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
						    
					    
							for(int i=0;i<list.size();i++){
								
								pstmt.setString(i+1, list.get(i));	    	
						    	
							   
						    }
							
							 pstmt.executeUpdate();	
						    
					   
							conn.close();
							
							
						  } catch(SQLIntegrityConstraintViolationException e){
							   System.out.println("Cannot insert duplicate Records...Unique key constraint");
						  }
						 
						  catch (SQLException e) {
							e.printStackTrace();
						  }
						 System.out.println("------------------------------------------------");		 
		}	
				
		
		
	
	
	//getResultSet() retrieve the rows of records from the database 
		
	 public ResultSet getResultSet(String tableName) {
		 
		 System.out.println("fetching the records from the table...");
		 Statement stmt = null;		
         ResultSet res=null;
				 
		 String query = "SELECT * FROM " + tableName+" ";

		    try {
		    	
		    	Connection conn =ConnectDB.getConnection();
		        stmt = conn.createStatement();
		        res = stmt.executeQuery(query);		       
		        
		        while(res.next())  
		        	System.out.println(res.getInt(1)+"  "+res.getString(2)+"  "+res.getString(3)
		        	      +" "+res.getString(4)+" "+res.getString(5)+" "+res.getString(6)
		        	      +" "+res.getString(7) +" "+res.getString(8)
		        	
		        	 );  
		        	
		        
		        
		        conn.close();  
		        
		        
		        
		        
		    } catch (SQLException e ) {
		        e.printStackTrace();
		    } 
	  
		return res;
			
	 }
	 
	 
	
	
}
