package  io.mountblue.contactus;
import java.sql.*;

public class LoginDao {
	static String sql = "SELECT * from adminData where name=? and password=?";
	static String url = "jdbc:postgresql://localhost:5432/contact-us";
    static String username = "postgres";
    static String password = "postgres";
    public boolean check(String name,String pass) {
	    try {
	    	Class.forName("org.postgresql.Driver");
	        Connection connection = DriverManager.getConnection(url, username, password);
	        PreparedStatement statement = connection.prepareStatement(sql);
	        
	        statement.setString(1,name);
	        statement.setString(2,pass);
	        
	        ResultSet resultSet = statement.executeQuery();
	        
	        return resultSet.next()?true:false;
	    }
	    catch( Exception e) {
	    	e.printStackTrace();
	    	return false;
	    }
    }
}
