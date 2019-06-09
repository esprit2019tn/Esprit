/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entity.Actualite;
import com.esprit.Entity.Event;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alaa
 */
public class ServiceActualite {
    public void AjouterActualite(Actualite a)
    {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://127.0.0.1/tasksApp/addTask.php?dateActu=" + d2s(a.getDateActu()) + "&descActu=" + a.getDesc()+ "&idEvent=" +a.getEventId();// création de l'URL
        System.out.println(Url);
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

//        con.addResponseListener((e) -> {
//            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
//            System.out.println(str);//Affichage de la réponse serveur sur la console
//        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
    public String d2s(Date date)
    {
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;    
    }
    
    public Date s2d(String string_date){
        long milliseconds=0;
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            Date d = f.parse(string_date);
            milliseconds = d.getTime();
            
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return new Date(milliseconds);
    }
    
    String str="";
    public String getEventJson(){
                ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1/tasksApp/getTasks.php");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // ServiceTask ser = new ServiceTask();
               // listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
               str=new String(con.getResponseData());
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return str;
    }
    
    public ArrayList<Event> parseListEventJson(String json) {

        ArrayList<Event> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
             if(!json.equals("\n]")){
            Map<String, Object> events = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Event e = new Event();
                e.setIdEvent((int) Float.parseFloat(obj.get("idEvent").toString()));
                e.setTitre(obj.get("titre").toString());
                e.setDesc(obj.get("description").toString());
                e.setCapaciteMin(Long.parseLong(obj.get("capaciteMax").toString()));
                e.setCapaciteMin(Long.parseLong(obj.get("capaciteMin").toString()));
                e.setDateEvent(obj.get("dateEvent").toString());
                e.setDuree(Long.parseLong(obj.get("duree").toString()));

                listTasks.add(e);

            }
          }
        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return listTasks;

    }
  
        public String getActuJson(){
                ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1/tasksApp/getActu.php");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               // ServiceTask ser = new ServiceTask();
               // listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
               str=new String(con.getResponseData());
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return str;
    }
    public ArrayList<Actualite> parseListActuJson(String json) {

        ArrayList<Actualite> listActualite = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            if(!json.equals("\r\n]")){
            Map<String, Object> events = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
            for (Map<String, Object> obj : list) {
                Actualite e = new Actualite();
                e.setNumActu((int) Float.parseFloat(obj.get("numActu").toString()));
                e.setDateActu(s2d(obj.get("dateActu").toString()));
                e.setDesc(obj.get("descActu").toString());
                e.setEventID(Integer.parseInt(obj.get("idEvent").toString()));

                listActualite.add(e);
            }
          }
        } catch (IOException ex) {
        }     
        return listActualite;
    }
}
