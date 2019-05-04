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

    public void create(Reclamation rcl) {
        try {
            String sql = " insert into reclamation  (textReclam,idReclama) "
                    + "values (?,?)";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setObject(1, "'" + rcl.getTexte()+ "'", Types.VARCHAR);
            st.setObject(2, "'" + rcl.getIdReclam()+ "'", Types.VARCHAR);

          
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Reclamation reclamation) {
        // TODO Auto-generated method stub
        try {
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate("insert into evenement  (textReclam,idReclam) "
                    + "values ('"
                    + reclamation.getIdReclam()+ "','"
                    + reclamation.getTexte()+ "','"
                   
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

   /* @Override
    public void update(Reclamation obj) {
        // TODO Auto-generated method stub
        try {
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate("update reclamation set "
                    + "idReclam = '" + obj.getIdReclam()+ "' ,"
                    + "textReclam = '" + obj.getTexte()+ "' ,"
                   
            System.out.println("Utilisateur N " + obj.getUser()+ " a a ete modifie");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/

    @Override
    public List<Reclamation> findAll() {
        // TODO Auto-generated method stub
        List<Reclamation> lstreclamation = new ArrayList<Reclamation>();
        try {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("select * from evenement");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                //Reclamation reclamation = new Reclamation(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getLong(4), rs.getLong(5), rs.getString(6),rs.getLong(7));
                //lstreclamation.add(reclamation);
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

    @Override
    public void update(Reclamation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
