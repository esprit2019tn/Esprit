package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.Event;
import Connection.ConnectionProperties;

public class EventDao implements IDao<Event> {

    //Connection cnx = ConnectionProperties.connect();
    Connection cnx = ConnectionProperties.getConnectionProperties().getCnx();

    public void create(Event evt) {
        try {
            String sql = " insert into evenement  (titre,description,capacitemax,capacitemin,dateevent,duree,idsponsor,idloc) "
                    + "values (?,?,?,?,?,?,?,?)";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setObject(1, "'" + evt.getTitre() + "'", Types.VARCHAR);
            st.setObject(2, "'" + evt.getDesc() + "'", Types.VARCHAR);
            st.setObject(3, "'" + evt.getCapaciteMax() + "'", Types.INTEGER);
            st.setObject(4, "'" + evt.getCapaciteMin() + "'", Types.INTEGER);
            // st.setObject(5, "'"+evt.getDateEvent()+"'",Types.DATE);
            // st.setDate(5, evt.getDateEvent());
            st.setObject(6, 4,Types.INTEGER);
            st.setObject(7, 4, Types.INTEGER);
            st.setObject(8, 3, Types.INTEGER);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Event event) {
        // TODO Auto-generated method stub
        try {
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate("insert into evenement  (titre,description,capacitemax,capacitemin,dateevent,duree,idsponsor,idloc) "
                    + "values ('"
                    + event.getTitre() + "','"
                    + event.getDesc() + "','"
                    + event.getCapaciteMax() + "','"
                    + event.getCapaciteMin() + "','"
                    + event.getDateEvent() + "',"
                    + event.getDuree() + ",1,1 "
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
            stmt.executeUpdate("delete from evenement where idEvent = " + id + "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Event obj) {
        // TODO Auto-generated method stub
        try {
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate("update event set "
                    + "nom = '" + obj.getTitre() + "' ,"
                    + "prenom = '" + obj.getDesc() + "' ,"
                    + "adresse = '" + obj.getCapaciteMax() + "' "
                    + "email = '" + obj.getCapaciteMin() + "' "
                    + "password = '" + obj.getDuree() + "' "
                    + "where id = " + obj.getDateEvent() + "");
            System.out.println("Utilisateur N� " + obj.getTitre() + " a �t� modifi�");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Event> findAll() {
        // TODO Auto-generated method stub
        List<Event> lstevent = new ArrayList<Event>();
        try {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("select * from evenement");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                Event event = new Event(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getLong(4), rs.getLong(5), rs.getString(6),rs.getLong(7));
                lstevent.add(event);
            }
            // cnx.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lstevent;
    }

    @Override
    public Event findById(String id) {
        Event event = null;
        try {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event WHERE "
                    + "idEvent='" + id + "'");
            while (rs.next()) {
                // event = new Event(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));	
            }
            cnx.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return event;
    }

    @Override
    public Event findUser(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
