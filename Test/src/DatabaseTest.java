import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 */

/**
 * @author Safwan
 *
 */
public class DatabaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
	        // 1. Register JDBC Driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        // 2. Create Connection Object
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/movie","root", "$vampire$");  
	        
	        // 3. Create Statement object and Execute a Query
	        Statement stmt = con.createStatement(); 
	        
	        // 4. Extract data from result set
	        ResultSet rs = stmt.executeQuery("select * from movies");  
	        while(rs.next()) {
	          System.out.println(rs.getInt("id") + "  " + rs.getString("title") + "  " + rs.getString("genres")); 
	        }
			    
	        // 5. Close the connection
	        con.close();
	        
	        } catch(Exception e){
	          e.printStackTrace();
	        }
	    }

	}


