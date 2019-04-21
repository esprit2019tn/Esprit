package Connection;

import java.sql.*;

public class ConnectionProperties {
	
	public static String url = "jdbc:mysql://localhost:3306/techeventdb";
	public static String username = "root";
	public static String password = "";
	private static Connection cnx = null ;

	private static ConnectionProperties cnpr ;
	
	private ConnectionProperties(){
		try {
			cnx = DriverManager.getConnection(url,username,password);
			System.out.println("connection succeed");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConnectionProperties getConnectionProperties(){
		if(cnpr==null)
			cnpr = new ConnectionProperties ();
		return cnpr ;
	}
	
	
	
	public static Connection connect(){
		Connection cnx = null ;
		try {
			cnx = DriverManager.getConnection(url,username,password);
			System.out.println("connection succeed");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnx ;
	}

	public Connection getCnx() {
		return cnx;
	}

}
