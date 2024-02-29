package  io.mountblue.contactus.dao;
import java.sql.*;

import io.mountblue.contactus.model.Admin;

public class AdminDao {
	static String sql = "SELECT * from adminData where name=? and password=?";
	static String url = "jdbc:postgresql://localhost:5432/contact-us";
    static String username = "postgres";
    static String password = "postgres";
    public boolean check(Admin admin) {
	    try {
	    	Class.forName("org.postgresql.Driver");
	        Connection connection = DriverManager.getConnection(url, username, password);
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1,admin.getName());
	        statement.setString(2,admin.getPassword());
	        
	        ResultSet resultSet = statement.executeQuery();
	        return resultSet.next()?true:false;
	    }
	    catch( Exception e) {
	    	e.printStackTrace();
	    	return false;
	    }
    }
}
