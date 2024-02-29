package io.mountblue.contactus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import io.mountblue.contactus.model.User;

public class UsersDao {
	static String url = "jdbc:postgresql://localhost:5432/contact-us";
	static String username = "postgres";
	static String password = "postgres";
    public void insertData(User user) {
	    try {
	    	Class.forName("org.postgresql.Driver");
	    	String sql = "INSERT INTO usersData(name, email, message)  VALUES (?,?,?)";
	    	
	        Connection connection = DriverManager.getConnection(url, username, password);
	        PreparedStatement statement = connection.prepareStatement(sql);	
	        
	        statement.setString(1,user.getName());
	        statement.setString(2,user.getMail());
	        statement.setString(3,user.getMessage());
	        
	        ResultSet resultSet = statement.executeQuery();
	        resultSet.next();
	    }
	    catch( Exception e) {
	    	e.printStackTrace();
	    }
    }
    public void changeStatus(Integer id,Boolean newStatus) {
   	    try {
	    	Class.forName("org.postgresql.Driver");
	    	String sql = "UPDATE usersData set status=? where id=?";

	        Connection connection = DriverManager.getConnection(url, username, password);
	        PreparedStatement statement = connection.prepareStatement(sql);	
	        
	        statement.setBoolean(1,newStatus);
	        statement.setInt(2,id);
	        
	        statement.executeUpdate();
	    }
	    catch( Exception e) {
	    	e.printStackTrace();
	    }
    }
}
