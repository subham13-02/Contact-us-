package io.mountblue.contactus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import io.mountblue.contactus.model.Request;

public class RequestDao {
	static String url = "jdbc:postgresql://localhost:5432/contact-us";
	static String username = "postgres";
	static String password = "postgres";
    public static void saveRequest(Request request) {
	    try {
	    	Class.forName("org.postgresql.Driver");
	    	String sql = "INSERT INTO usersData(name, email, message, status)  VALUES (?,?,?,?)";
	        Connection connection = DriverManager.getConnection(url, username, password);
	        PreparedStatement statement = connection.prepareStatement(sql);	
	        statement.setString(1,request.getName());
	        statement.setString(2,request.getEmail());
	        statement.setString(3,request.getMessage());
	        statement.setBoolean(4,request.getStatus());
	        
	        ResultSet resultSet = statement.executeQuery();
	        resultSet.next();
	    }
	    catch( Exception e) {
	    	e.printStackTrace();
	    }
    }
    public static void changeStatus(Integer id,Boolean newStatus) {
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
    public static List<Request> fetchRequests(boolean status){
    	List<Request> requestedData = new ArrayList<>();
   	    try {
	    	Class.forName("org.postgresql.Driver"); 
	    	String sql = "select * from usersData where status="+status;
	        Connection connection = DriverManager.getConnection(url, username, password);
	        Statement st = connection.createStatement();	
	        
	        ResultSet resultSet = st.executeQuery(sql);
	        while(resultSet.next()) {
	        	Request requests=new Request();
	        	requests.setId(resultSet.getInt(1));
	        	requests.setName(resultSet.getString(2));
	        	requests.setEmail(resultSet.getString(3));
	        	requests.setMessage(resultSet.getString(4));
	        	requests.setStatus(resultSet.getBoolean(5));
	        	requestedData.add(requests);
	        }
	        return requestedData;
	    }
	    catch( Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
    }
}
