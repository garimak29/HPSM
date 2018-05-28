import java.sql.*;
public class Test
{
	static final String jdbc_driver="com.jdbc.mysql.driver";
	static final String jdbc_url="jdbc:mysql://localhost/";
	
	static final String user="root";
	static final String pass="root";
	
	public static void main(String args[])
	{
		Connection conn=null;
		Statement stmt=null;
		try{
			Class.forName("com.jdbc.mysql.driver");
			System.out.println("Connecting to database...");
		    conn = DriverManager.getConnection(jdbc_url, user, pass);
		    System.out.println("Creating database...");
		      stmt = conn.createStatement();
		      
		      String sql = "CREATE DATABASE STUDENTS";
		      stmt.executeUpdate(sql);
		      System.out.println("Database created successfully...");
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}
	}