package StudentDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class StudentDBConnection{
	
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/studentdb";
	static String usern = "root";
	static String password = "Spaceshuttle";
	
		public static Connection getConnection() throws Exception{
			
			Class.forName(driver);
				
			Connection c = DriverManager.getConnection(url, usern, password);
			//System.out.println("connected");
			return c;
		}
					
}
	
	
