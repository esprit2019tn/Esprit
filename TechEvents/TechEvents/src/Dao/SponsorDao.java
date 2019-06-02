/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.ConnectionProperties;
import Entity.Event;
import Entity.Sponsor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Lenovo
 */
public class SponsorDao implements IDao<Sponsor> {

    Connection cnx = ConnectionProperties.getConnectionProperties().getCnx();

    @Override
    public void insert(Sponsor obj) {
        try {

            Statement stmt = cnx.createStatement();
            stmt.executeUpdate("insert into sponsorevent (idEvent,idSponsor) values ('" + obj.getName() + "','" + obj.getDesc() + "')");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void updateSponsorEvt(Event evt, ArrayList<Sponsor> obj) {
        try {
            for (Sponsor spr : obj) {
                Statement stmt = cnx.createStatement();
                stmt.executeUpdate("insert into sponsorevent (idEvent,idSponsor) values (" + evt.getIdEvent() + "," + spr.getIdSponsor() + ")");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean eventHasSponsor(Event evt) {
        try {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("select * from sponsorevent where idEvent = " + evt.getIdEvent() + "");
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
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Sponsor obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Sponsor> findByEvent(Event ev) {
        List<Sponsor> lstsponsor = new ArrayList<Sponsor>();
        try {
            Statement pst = cnx.prepareStatement("select * from sponsor");
            ResultSet rs = pst.executeQuery("select s.*  from sponsor s, evenement e, sponsorevent se where e.idEvent = "+ev.getIdEvent()+" and s.idsponsor = se.idsponsor and se.idEvent ="+ev.getIdEvent()+"");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

                //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                Sponsor spr = new Sponsor(rs.getInt(1), rs.getString(2), rs.getString(3));
                lstsponsor.add(spr);
            }
            // cnx.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lstsponsor ;
    }

    @Override
    public List<Sponsor> findAll() {
        List<Sponsor> lstsponsor = new ArrayList<Sponsor>();
        try {
            Statement pst = cnx.prepareStatement("select * from sponsor");
            ResultSet rs = pst.executeQuery("select * from sponsor");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

                //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                Sponsor spr = new Sponsor(rs.getInt(1), rs.getString(2), rs.getString(3));
                lstsponsor.add(spr);
            }
            // cnx.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lstsponsor;
    }

    @Override
    public Sponsor findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sponsor findUser(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void createSpr(Sponsor spr){
         try {

            Statement stmt = cnx.createStatement();
            stmt.executeUpdate("insert into sponsor (nom,matricule,fondateur,origine,domaine,responsable) "
                    + "values ('" + spr.getName() + "'," + spr.getMatricule() + ",'"+spr.getFondateur()+
                    "','"+spr.getOrigine()+"','"+spr.getDomaine()+"','"+spr.getResponsable()+"')");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
