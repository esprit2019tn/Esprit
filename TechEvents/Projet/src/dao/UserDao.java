package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entities.User;
import main.ConnectionProperties;

public class UserDao implements IDao<User> {

	//Connection cnx = ConnectionProperties.connect();
	Connection cnx = ConnectionProperties.getConnectionProperties().getCnx();
	
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		try {
			Statement stmt = cnx.createStatement();
			stmt.executeUpdate("insert into user  (nom,prenom,adresse) values ('" 
			        + user.getNom() + "','"
					+ user.getPrenom() + "','"
			        +user.getAdresse()+"') ");
			System.out.println("Utilisateur "+user.getNom()+""
			                                 +user.getPrenom()+""
			                                 +user.getAdresse()+
			                   "créer avec succées");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}

	@Override
	public void delete(int id) {
		try {
			Statement stmt = cnx.createStatement();
			stmt.executeUpdate("delete from user where id = "+id+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		System.out.println("Utilisateur N° "+id+" supprimé");
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		try {
			Statement stmt = cnx.createStatement();
			stmt.executeUpdate("update user set "
					+ "nom = '"+ user.getNom() +"' ,"
					+ "prenom = '"+ user.getPrenom() +"' ,"
					+ "adresse = '" +user.getAdresse()+"' "
					+ "where id = "+user.getId()+""); 
					
			System.out.println("Utilisateur N° "+user.getId()+" a été modifié");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}

	@Override
	public void findAll() {
		// TODO Auto-generated method stub
		List<User> lstuser = new ArrayList<User>();
		try {
			Statement stmt = cnx.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user");  
			while (rs.next()){
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			User user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			lstuser.add(user);
			
			}
			cnx.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public void findById() {
		// TODO Auto-generated method stub
		
	}
	
	

}
