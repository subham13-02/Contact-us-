package io.mountblue.contactus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import io.mountblue.contactus.model.User;

public class UsersDao {
    public void insertData(User user) {
	    try {
	    	String sql = "INSERT INTO usersData(name, email, message)  VALUES (?,?,?)";
	    	String url = "jdbc:postgresql://localhost:5432/contact-us";
	        String username = "postgres";
	        String password = "postgres";
	    	Class.forName("org.postgresql.Driver");
	    	
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
}
