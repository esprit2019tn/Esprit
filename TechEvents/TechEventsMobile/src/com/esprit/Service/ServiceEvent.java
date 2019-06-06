/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class ServiceEvent {

    public void ajoutTask(Event evt) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
//        String Url = "http://41.226.11.252:1130/tasks/" + evt.getTitre() + "/" + evt.getDesc() +
//                     "/"+evt.getCapaciteMax()+"/"+evt.getCapaciteMin()+"/"+evt.getDateEvent()+
//                      "/"+evt.getDuree();// création de l'URL
        String Url = "http://localhost/Servers/Event/addEvent.php?titre=" + evt.getTitre()
                + "&description=" + evt.getDesc() + "&capacitemax=" + evt.getCapaciteMax()
                + "&capacitemin=" + evt.getCapaciteMin() + "&dateevent='"+evt.getDateEvent()+"'"//"+evt.getDateEvent()+"
                + "&duree=" + evt.getDuree() + "&photoPath='"+evt.getPathphoto()+"'";//+"&img="+evt.getImage();
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

    public ArrayList<Event> parseListTaskJson(String json) {

        ArrayList<Event> listEvents = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Event e = new Event();

                //float id = Float.parseFloat(obj.get("id").toString());
                String p = "";
                e.setIdEvent(Integer.parseInt(obj.get("idEvent").toString()));
                e.setTitre(obj.get("titre").toString());
                e.setDesc(obj.get("description").toString());
                e.setPathphoto(obj.get("photoPath").toString());
                e.setDateEvent(obj.get("dateEvent").toString());
                e.setDuree(Long.parseLong(obj.get("duree").toString()));
                e.setCapaciteMax(Long.parseLong(obj.get("capaciteMax").toString()));
                e.setCapaciteMin(Long.parseLong(obj.get("capaciteMin").toString()));

                System.out.println(e);

                listEvents.add(e);

            }

        } catch (IOException ex) {
        }

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        System.out.println(listEvents);
        return listEvents;

    }
    ArrayList<Event> listEvents = new ArrayList<>();

    public ArrayList<Event> getList2() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Servers/Event/getEvent.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println("0" + listEvents);
                ServiceEvent ser = new ServiceEvent();
                listEvents = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }

}
