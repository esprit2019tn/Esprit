package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.User;
import Entity.Event;
import Connection.ConnectionProperties;
import Entity.Localisation;
import Entity.RoleUser;
import Entity.User;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;

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
            st.setObject(6, 4, Types.INTEGER);
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
            stmt.executeUpdate("insert into evenement  (titre,description,capacitemax,capacitemin,dateevent,duree,photoEvent,idsponsor,idloc) "
                    + "values ('"
                    + event.getTitre() + "','"
                    + event.getDesc() + "','"
                    + event.getCapaciteMax() + "','"
                    + event.getCapaciteMin() + "','"
                    + event.getDateEvent() + "',"
                    + event.getDuree() + ",'"
                    + event.getImage() + "'"
                    + ",1,1 "
                    + ") ");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void inserer(Event evt, File fl) {
        try {
            ImageView p = new ImageView();
            // File fileImage = new File(p.);
//            BufferedImage bImage = SwingFXUtils.fromFXImage(evt.getImage().getImage(), null);
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                ImageIO.write(bImage, "png", outputStream);
//                byte[] res = outputStream.toByteArray();
//                InputStream inputStream = new ByteArrayInputStream(res);

            //  File imgfile = new File("C:\\Users\\ikb\\Desktop\\img.png");
            FileInputStream input = new FileInputStream(fl);

            // InputStream input = imgfile.geti
            // Image image = new Image(input);
            // ImageView imageView = new ImageView(image);
            PreparedStatement pre = cnx.prepareStatement("insert into  evenement (titre,description,capacitemax,capacitemin,photoEvent,dateevent,duree,idsponsor,idloc) values(?,?,?,?,?,?,?,?,?)");

            pre.setString(1, evt.getTitre());
            pre.setString(2, evt.getDesc());
            pre.setLong(3, evt.getCapaciteMax());
            pre.setLong(4, evt.getCapaciteMin());
            pre.setBinaryStream(5, (InputStream) input, (int) fl.length());
            pre.setString(6, evt.getDateEvent());
            pre.setLong(7, evt.getDuree());
            pre.setInt(8, 1);
            pre.setInt(9, 1);

            // pre.setBinaryStream(2, input);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id
    ) {
        try {
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate("delete from evenement where idEvent = " + id + "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void e(String a, int za) {
        try {
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate("UPDATE evenement SET titre =  '" + a + "' WHERE idEvent =" + za);
        } catch (Exception z) {

        }
    }

    @Override
    public void update(Event obj) {
        // TODO Auto-generated method stub
        try {
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate("update evenement set "
                    + "titre = '" + obj.getTitre() + "' ,"
                    + "description = '" + obj.getDesc() + "' ,"
                    + "capaciteMax = " + obj.getCapaciteMax() + ", "
                    + "capaciteMin = " + obj.getCapaciteMin() + ", "
                    + "dateEvent = '" + obj.getDateEvent() + "' "
                    + "where idEvent = " + obj.getIdEvent() + "");
            System.out.println("Event " + obj.getTitre() + " a été modifié");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String updateUserEvt(Event evt, User usr) {
        // TODO Auto-generated method stub
        try {
            Statement stmt = cnx.createStatement();
            // ResultSet rs = stmt.executeQuery("select * from eventuser where UserID = " + evt.getIdEvent() + " and EventID = " + usr.getId() + "");
            // if (rs == null || rs.next() == false) {
            stmt.executeUpdate("insert into eventuser (EventID,UserID) values (" + evt.getIdEvent() + "," + usr.getId() + ")");
            System.out.println("Event " + evt.getIdEvent() + " a été affecté à user n°" + usr.getId());
            //} else {
            //  return null;
            // }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public boolean existe(Event evt, User usr) {
        try {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("select * from eventuser where UserID = " + usr.getId() + " and EventID = " + evt.getIdEvent() + "");
            if (rs == null || rs.next() == false) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Event> findAll() {
        // TODO Auto-generated method stub
        List<Event> lstevent = new ArrayList<Event>();
        try {
            // Statement stmt = cnx.createStatement();
            //ResultSet rs = stmt.executeQuery("select * from evenement");

            Statement pst = cnx.prepareStatement("select * from evenement");
            ResultSet rs = pst.executeQuery("select * from evenement");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                InputStream is = rs.getBinaryStream("photoEvent");
                OutputStream os = new FileOutputStream(new File("img.jpg"));
                byte[] content = new byte[1024];
                int size = 0;

                while ((size = is.read(content)) != -1) {
                    os.write(content, 0, size);
                }
                os.close();
                is.close();
                Image img = new Image("file:img.jpg", 111, 111, true, true);
                ImageView imv = new ImageView(img);
                imv.setFitWidth(111);
                imv.setFitHeight(111);
                imv.setPreserveRatio(true);

                //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                Event event = new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getLong(5), rs.getString(6), rs.getLong(7), imv);
                lstevent.add(event);
            }
            // cnx.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstevent;
    }

    public List<Event> findReservationByEvent(User usr) {
        // TODO Auto-generated method stub
        List<Event> lstevent = new ArrayList<Event>();
        try {
            // Statement stmt = cnx.createStatement();
            //ResultSet rs = stmt.executeQuery("select * from evenement");

            Statement pst = cnx.prepareStatement("select * from evenement , eventuser , user where eventuser.UserID = " + usr.getId() + " and user.idUser = " + usr.getId() + " and eventuser.EventId = evenement.idEvent");
            ResultSet rs = pst.executeQuery("select * from evenement , eventuser , user where eventuser.UserID = " + usr.getId() + " and user.idUser = " + usr.getId() + " and eventuser.EventId = evenement.idEvent");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                InputStream is = rs.getBinaryStream("photoEvent");
                OutputStream os = new FileOutputStream(new File("img.jpg"));
                byte[] content = new byte[1024];
                int size = 0;

                while ((size = is.read(content)) != -1) {
                    os.write(content, 0, size);
                }
                os.close();
                is.close();
                Image img = new Image("file:img.jpg", 111, 111, true, true);
                ImageView imv = new ImageView(img);
                imv.setFitWidth(111);
                imv.setFitHeight(111);
                imv.setPreserveRatio(true);

                //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                Event event = new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getLong(5), rs.getString(6), rs.getLong(7), imv);
                lstevent.add(event);
            }
            // cnx.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Event> findEventByUser(String idUser) {
        List<Event> lstEvent = null;
        Localisation localisation = new Localisation();
        try {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select e.* from evenement e "
                    + "inner join organisation o "
                    + "where o.idUser='" + idUser + "'");
            while (rs.next()) {
                Event event = new Event(0, idUser, idUser, Long.MAX_VALUE, Long.MAX_VALUE, idUser, Long.MIN_VALUE, localisation);
                lstEvent.add(event);
            }
            //cnx.close();  
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lstEvent;
    }
}
