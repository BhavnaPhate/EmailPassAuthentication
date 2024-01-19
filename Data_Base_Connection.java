package servlet.project;

import java.sql.Connection;
import java.sql.DriverManager;

public class Data_Base_Connection {
	protected static Connection db_con()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc";
			String user="root";
			String pswd="root";
			Connection con=DriverManager.getConnection(url,user,pswd);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
