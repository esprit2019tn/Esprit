package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.Actualite;
import Connection.ConnectionProperties;

public class ActualiteDao implements IDao<Actualite> {

    //Connection cnx = ConnectionProperties.connect();
    Connection cnx = ConnectionProperties.getConnectionProperties().getCnx();

    public void create(Actualite act) {
        try {
            String sql = " insert into actualite  (titre,description,capacitemax,capacitemin,dateact,duree,idsponsor,idloc) "
                    + "values (?,?,?,?,?,?,?,?)";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setObject(1, "'" + act.getNumActu() + "'", Types.VARCHAR);
            st.setObject(2, "'" + act.getDesc() + "'", Types.VARCHAR);
          //  st.setObject(3, "'" + act.getCapaciteMax() + "'", Types.INTEGER);
           // st.setObject(4, "'" + act.getCapaciteMin() + "'", Types.INTEGER);
            // st.setObject(5, "'"+act.getDateActualite()+"'",Types.DATE);
            // st.setDate(5, act.getDateActualite());
            st.setObject(6, 4,Types.INTEGER);
            st.setObject(7, 4, Types.INTEGER);
            st.setObject(8, 3, Types.INTEGER);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Actualite act) {
        // TODO Auto-generated method stub
        try {
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate("insert into actualite  (titre,description,capacitemax,capacitemin,dateact,duree,idsponsor,idloc) "
                    + "values ('"
                    + act.getNumActu()+ "','"
                    + act.getDesc() + "','"
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
            stmt.executeUpdate("delete from actualite where idActualite = " + id + "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Actualite obj) {
        // TODO Auto-generated method stub
        try {
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate("update act set "
                    + "nom = '" + obj.getNumActu() + "' ,"
                    + "prenom = '" + obj.getDesc() + "' ,"
                    + "where id = " + obj.getDateActu() + "");
            System.out.println("Utilisateur N� " + obj.getNumActu() + " a �t� modifi�");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Actualite> findAll() {
        // TODO Auto-generated method stub
        List<Actualite> lstact = new ArrayList<Actualite>();
        try {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("select * from actualite");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
              //  lstact.add(act);
            }
            // cnx.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lstact;
    }

    @Override
    public Actualite findById(String id) {
        Actualite act = null;
        try {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM act WHERE "
                    + "idActualite='" + id + "'");
            while (rs.next()) {
                // act = new Actualite(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));	
            }
            cnx.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return act;
    }

    @Override
    public Actualite findUser(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
