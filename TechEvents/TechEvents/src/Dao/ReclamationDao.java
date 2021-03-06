package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.Reclamation;
import Connection.ConnectionProperties;
import Entity.Reclamation;

public class ReclamationDao implements IDao<Reclamation> {

    //Connection cnx = ConnectionProperties.connect();
    Connection cnx = ConnectionProperties.getConnectionProperties().getCnx();
    UserDao du = new UserDao();
    EventDao ev = new EventDao();

    @Override
    public void insert(Reclamation reclamation) {
        // TODO Auto-generated method stub
        try {
            System.out.println("Dao.ReclamationDao.insert()"+reclamation);
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate("insert into reclamation  (textReclam,sujetReclam,idEvent,idUser) "
                    + "values ('"
                    + reclamation.getTextReclam()+ "','"
                    + reclamation.getSujetReclam()+ "',"
                    + reclamation.getEvent().getIdEvent()+ ","
                    + reclamation.getUser().getId()                 
                    + ") ");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate("delete from reclamation where idReclamation = " + id + "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Reclamation obj) {
        // TODO Auto-generated method stub
        try {
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate("update reclamation set "
                    + "sujet = '" + obj.getSujetReclam()+ "' ,"
                    + "textReclam = '" + obj.getTextReclam()+ "' ,");
                   
            System.out.println("Utilisateur N " + obj.getUser()+ " a a ete modifie");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Reclamation> findAll() {
        // TODO Auto-generated method stub
        List<Reclamation> lstreclamation = new ArrayList<Reclamation>();
        try {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("select * from reclamation");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+ du.findById(rs.getInt(5)) +ev.findById(rs.getInt(4))+  "  " + rs.getString(6) );
            Reclamation reclamation = new Reclamation(rs.getInt(1),rs.getString(2), rs.getString(3) , du.findById(rs.getInt(5)) ,ev.findById(rs.getInt(4)) ,rs.getString(6)  );
                lstreclamation.add(reclamation);
            }
            // cnx.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lstreclamation;
    }
    
  

    @Override
    public Reclamation findById(String id) {
        Reclamation reclamation = null;
        try {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM reclamation WHERE "
                    + "idReclamation='" + id + "'");
            while (rs.next()) {
                // reclamation = new Reclamation(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));	
            }
            cnx.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reclamation;
    }

    @Override
    public Reclamation findUser(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
