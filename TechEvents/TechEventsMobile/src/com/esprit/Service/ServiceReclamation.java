/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates3
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entity.Event;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.esprit.Entity.Reclamation;
import com.esprit.Entity.User;
import com.esprit.Metier.UserSession;
import com.esprit.gui.ListEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class ServiceReclamation {

    public void ajoutReclamation(Reclamation rec) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
//        String Url = "http://41.226.11.252:1130/tasks/" + evt.getTitre() + "/" + evt.getDesc() +
//                     "/"+evt.getCapaciteMax()+"/"+evt.getCapaciteMin()+"/"+evt.getDateEvent()+
//                      "/"+evt.getDuree();// création de l'URL
        String Url = "http://localhost/Servers/Reclamation/addreclamation.php?sujet="+rec.getSujetReclam()+""
                + "&text="+rec.getTextReclam()+""
                + "&iduser="+UserSession.getUserSession().getId()+""
                + "&idevent="+ListEvent.getEvtStatic().getIdEvent()+"";
                //+"&img="+evt.getImage();
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
    public void UpdateEvent(Event evt) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
//        String Url = "http://41.226.11.252:1130/tasks/" + evt.getTitre() + "/" + evt.getDesc() +
//                     "/"+evt.getCapaciteMax()+"/"+evt.getCapaciteMin()+"/"+evt.getDateEvent()+
//                      "/"+evt.getDuree();// création de l'URL
        String Url = "http://localhost/Servers/Event/updateEvent.php?idEvent="+evt.getIdEvent()+"&titre=" + evt.getTitre()
                + "&description=" + evt.getDesc() + "&capacitemax=" + evt.getCapaciteMax()
                + "&capacitemin=" + evt.getCapaciteMin() + "&duree=" + evt.getDuree();//+"&img="+evt.getImage();
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<Reclamation> parseListTaskJson(String json) {
        ServiceEvent sev = new ServiceEvent();
        ArrayList<Reclamation> listReclamation = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Reclamation e = new Reclamation();

                //float id = Float.parseFloat(obj.get("id").toString());
                String p = "";
                e.setIdReclam(Integer.parseInt(obj.get("idReclam").toString()));
                e.setTextReclam(obj.get("textReclam").toString());
                e.setSujetReclam(obj.get("sujetReclam").toString());
                User usr = new User();
                usr.setId(Integer.parseInt(obj.get("idUser").toString()));
                e.setUser(usr);
                Event evt = new Event();
                int idEvent = Integer.parseInt(obj.get("idEvent").toString());
                evt.setIdEvent(Integer.parseInt(obj.get("idEvent").toString()));
                e.setEvent(sev.getEventById(idEvent));
                e.setDateReclam(obj.get("dateReclamation").toString());
                System.out.println(e.getDateReclam());

                listReclamation.add(e);

            }

        } catch (IOException ex) {
        }

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        System.out.println(listReclamation);
        return listReclamation;

    }
    ArrayList<Reclamation> listReclamation = new ArrayList<>();

    public ArrayList<Reclamation> getListReclamation() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Servers/Reclamation/getReclamation.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println("0" + listReclamation);
                ServiceReclamation ser = new ServiceReclamation();
                listReclamation = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listReclamation;
    }

}
