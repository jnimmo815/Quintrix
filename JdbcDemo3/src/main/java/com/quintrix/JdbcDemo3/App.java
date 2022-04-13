package com.quintrix.JdbcDemo3;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args ) throws SQLException 
    {
    	insert();
    	update();
    	
    }
    
    public static void insert() throws SQLException
    {
    	Connection connection = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO EMPLOYEE VALUES (?, ?,?)";
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
          connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "root");
          
          
          pstmt = connection.prepareStatement(sql);  
          pstmt.setInt(1, 7);
          pstmt.setString(2, "Tom");
          pstmt.setString(3, "Mainger");             
          int affectedRows = pstmt.executeUpdate();
          System.out.println(affectedRows + " row(s) affected !!");
        } 
        catch (Exception e) {
          e.printStackTrace();
        }finally {
          try {
            pstmt.close();
            connection.close();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
    }
    
    public static void update() throws SQLException
    {    	
    	Connection connection = null;    	
    	
    	String sql = "UPDATE EMPLOYEE SET FIRST_NAME = 'tom' WHERE ID = '5'";
    	try
        {
          Class.forName("com.mysql.jdbc.Driver");
          connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "root");
          Statement stmt = connection.createStatement();
          stmt.executeUpdate(sql);
          stmt.close();          
        }
    	catch (Exception e) {
    	      e.printStackTrace();
    	    }finally {
    	      try {    	       
    	        connection.close();
    	      } catch (Exception e) {
    	        e.printStackTrace();
    	      }
    	    }
    }
    
}
