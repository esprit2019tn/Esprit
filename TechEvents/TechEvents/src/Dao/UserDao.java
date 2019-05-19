package Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.User;
import Connection.ConnectionProperties;
import Entity.RoleUser;

public class UserDao implements IDaoClient {

	//Connection cnx = ConnectionProperties.connect();
	Connection cnx = ConnectionProperties.getConnectionProperties().getCnx();
	
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		try {   
			Statement stmt = cnx.createStatement();
			stmt.executeUpdate("insert into user  (nom,prenom,dateNaiss,sexe,adresse,email,password,role,confirmationCode) "
                                + "values ('" 
			        + user.getNom() + "','"
				+ user.getPrenom() + "','"
			        +user.getDateNaiss()+ "','"
			        +user.getSexe()+ "','"
			        +user.getAdresse()+ "','"                                
                                +user.getEmail()+ "','"
                                +user.getPassword()+ "','"
                                +user.getRole()+ "','"
                                +user.getConfirmationCode()+"') ");

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
			//cnx.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                return lstuser;
    }
    public List<User> findUserToValid() {
		// TODO Auto-generated method stub
		List<User> lstuser = new ArrayList<User>();
		try {
			Statement stmt = cnx.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user where active=0 ");  
			while (rs.next()){
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),RoleUser.valueOf(rs.getString(9)), rs.getString(10),rs.getBoolean(11),rs.getBoolean(12));
			lstuser.add(user);
			
			}
			//cnx.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                return lstuser;
    }

    @Override
    public User findById(int id) {
		User user = null;
		try {
			Statement stmt = cnx.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM user WHERE "
                                + "idUser='"+id+"'");  
			while (rs.next()){
			 user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),RoleUser.valueOf(rs.getString(9)), rs.getString(10),rs.getBoolean(11),rs.getBoolean(12));
			}
			//cnx.close();  
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
			 user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),RoleUser.valueOf(rs.getString(9)), rs.getString(10),rs.getBoolean(11),rs.getBoolean(12));			
			}
			//cnx.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                return user;
    }
    
    
    public User findUserByEmail(String email) {
		User user = null;
		try {
			Statement stmt = cnx.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM user WHERE "
                                + " email='"+email+"'");  
			while (rs.next()){
			 user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),RoleUser.valueOf(rs.getString(9)), rs.getString(10),rs.getBoolean(11),rs.getBoolean(12));			
			}
			//cnx.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                return user;
    }
    
    
    
    public String getConfirmationCode(String email) {
		String code = null;
		try {
			Statement stmt = cnx.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT confirmationCode FROM user WHERE "
                                + "email='"+email+"'");  
			while (rs.next()){
			code=rs.getString("confirmationCode");
			}
			//cnx.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                return code;
    }
    
        public Boolean setConfirmationEmail(String email) {
            Boolean rs=false;
		try {
			Statement stmt = cnx.createStatement();
			/* rs=stmt.execute("UPDATE user "
                                +"SET confirmation ="+Boolean.TRUE
                                +"where email='"+email+"'");     */
                        rs=stmt.execute(
                         "UPDATE user SET confirmation =1 "+
                         " where email='"+email+"'"
                        );
 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                return rs;
    }
        
        public  Boolean setValidationUser(String email) {
            Boolean rs=false;
		try {
			Statement stmt = cnx.createStatement();
			/* rs=stmt.execute("UPDATE user "
                                +"SET confirmation ="+Boolean.TRUE
                                +"where email='"+email+"'");     */
                        rs=stmt.execute(
                         "UPDATE user SET active =1 "+
                         " where email='"+email+"'"
                        );
 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                return rs;
    }
    
        
            public List<User> findUserByEvent(String idEvent) {
		List<User> lstUser = null;
		try {
			Statement stmt = cnx.createStatement();
			ResultSet rs=stmt.executeQuery(
                                "select u.*  " +
                                " from user " +
                                " inner join organisation " +
                                " where o.idEvent='"+idEvent+"'");  
			while (rs.next()){
			 User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),RoleUser.valueOf(rs.getString(9)), rs.getString(10),rs.getBoolean(11),rs.getBoolean(12));			
			lstUser.add(user);
                        }
			//cnx.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                return lstUser;
    }
    
    
    
    







	
	

}
