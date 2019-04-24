package Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.User;
import Connection.ConnectionProperties;

public class UserDao implements IDao<User> {

	//Connection cnx = ConnectionProperties.connect();
	Connection cnx = ConnectionProperties.getConnectionProperties().getCnx();
	
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		try {
			Statement stmt = cnx.createStatement();
			stmt.executeUpdate("insert into user  (nom,prenom,adresse,email,password) "
                                + "values ('" 
			        + user.getNom() + "','"
				+ user.getPrenom() + "','"
			        +user.getAdresse()+ "','"
                                +user.getEmail()+ "','"
                                +user.getPassword()+"') ");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}

	@Override
	public void delete(int id) {
		try {
			Statement stmt = cnx.createStatement();
			stmt.executeUpdate("delete from user where idUser = "+id+"");
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
	}

    @Override
    public void update(User obj) {
		// TODO Auto-generated method stub
		try {
			Statement stmt = cnx.createStatement();
			stmt.executeUpdate("update user set "
					+ "nom = '"+ obj.getNom() +"' ,"
					+ "prenom = '"+ obj.getPrenom() +"' ,"
					+ "adresse = '" +obj.getAdresse()+"' "
                                        + "email = '" +obj.getAdresse()+"' "
                                        + "password = '" +obj.getAdresse()+"' "
					+ "where id = "+obj.getId()+""); 				
			System.out.println("Utilisateur N� "+obj.getId()+" a �t� modifi�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }

    @Override
    public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> lstuser = new ArrayList<User>();
		try {
			Statement stmt = cnx.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user");  
			while (rs.next()){
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			User user = new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			lstuser.add(user);
			
			}
			cnx.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                return lstuser;
    }

    @Override
    public User findById(String id) {
		User user = null;
		try {
			Statement stmt = cnx.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM user WHERE "
                                + "idUser='"+id+"'");  
			while (rs.next()){
			 user = new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));	
			}
			cnx.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                return user;
    }
    
    @Override
    public User findUser(String email,String password) {
		User user = null;
		try {
			Statement stmt = cnx.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM user WHERE "
                                + "password='"+password+"'"
                                + "and email='"+email+"'");  
			while (rs.next()){
			 user = new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			
			}
			cnx.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                return user;
    }
    
    
    
    
    







	
	

}
