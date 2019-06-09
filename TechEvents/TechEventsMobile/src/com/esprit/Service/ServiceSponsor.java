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
import com.esprit.Entity.Sponsor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class ServiceSponsor {

    public void ajoutSponsor(Event evt) {
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
    
    public void addsponsorToevent(Event evt ,List<Sponsor> sr){
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        for(Sponsor spr :sr){
        String Url = "http://localhost/Servers/Sponsor/addSponsorToEvent.php?idevent=" + evt.getIdEvent()
                + "&idsponsor=" + spr.getIdSponsor()
                + "";//+"&img="+evt.getImage();
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        }
    }
    
    public void deletesponsorToevent(Event evt){
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/Servers/Sponsor/deleteSponsorEvent.php?idevent=" + evt.getIdEvent();
//+"&img="+evt.getImage();
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
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

    public ArrayList<Sponsor> parseListTaskJson(String json) {

        ArrayList<Sponsor> listEvents = new ArrayList<>();
        System.out.println("7"+json);
//        if(!json.startsWith("["))
//            return listEvents ;
        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Sponsor e = new Sponsor();

                //float id = Float.parseFloat(obj.get("id").toString());
                String p = "";
                e.setIdSponsor(Integer.parseInt(obj.get("idSponsor").toString()));
                e.setName(obj.get("nom").toString());
                e.setDomaine(obj.get("domaine").toString());
                e.setFondateur(obj.get("fondateur").toString());
                e.setOrigine(obj.get("origine").toString());
                e.setResponsable(obj.get("responsable").toString());
                e.setMatricule(Integer.parseInt(obj.get("matricule").toString()));

                System.out.println(e);

                listEvents.add(e);

            }

        } catch (IOException ex) {
            ex.printStackTrace();
            return listEvents ;
        }

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        System.out.println(listEvents);
        return listEvents;

    }
    ArrayList<Sponsor> listSponsors = new ArrayList<>();

    public ArrayList<Sponsor> getListSponsorByEvent(Event e) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Servers/Sponsor/getSponsorEvent.php?idevent="+e.getIdEvent());
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println("0" + listSponsors);
                ServiceSponsor ser = new ServiceSponsor();
                listSponsors = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listSponsors;
    }
    
    public ArrayList<Sponsor> getListSponsor() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Servers/Sponsor/getSponsor.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println("0" + listSponsors);
                ServiceSponsor ser = new ServiceSponsor();
                listSponsors = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listSponsors;
    }

}
