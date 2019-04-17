package main;

import java.sql.Connection;

import dao.UserDao;
import entities.User;

import java.sql.* ;


public class Connect {

	public static String url = "jdbc:mysql://localhost:3306/bd1";
	public static String username = "root";
	public static String password = "";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		User u = new User(12,"lamjed","3amer","gabes") ;
		userDao.update(u);
		//userDao.delete(11);
		System.out.println("-----------------------------");
//		try {
//			Connection cnx = DriverManager.getConnection(url,username,password);
//			System.out.println("connection succeed");
//			
//			
//			
//			Statement stmt=cnx.createStatement(); 
//			//stmt.executeUpdate("insert into user  (nom,prenom,adresse) values ('mohamed','ahmed','ariana') ");
//			
//			ResultSet rs=stmt.executeQuery("select * from user");  
//			while (rs.next())
//				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
//			cnx.close();  
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

}
