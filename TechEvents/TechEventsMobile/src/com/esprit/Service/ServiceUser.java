/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.esprit.Entity.RoleUser;
import com.esprit.Entity.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;




/**
 *
 * @author bhk
 */
public class ServiceUser {

    public static void ajoutUser(User user) {
           ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/Servers/user/addUser.php";// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.addArgument("nom",user.getNom());
        con.addArgument("prenom", user.getPrenom());
        con.addArgument("dateNaiss", user.getDateNaiss().toString() );
        con.addArgument("sexe",user.getSexe());
        con.addArgument("adresse", user.getAdresse());
        con.addArgument("email", user.getEmail());
        con.addArgument("password", user.getPassword());
        con.addArgument("role", RoleUser.SimpleUser.toString());
        con.addArgument("confirmationCode",user.getConfirmationCode());
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager

   
    }

    public static ArrayList<User> parseListTaskJson(String json) {

        ArrayList<User> listUsers = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

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
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                User u = new User();                
                u.setId(Integer.valueOf(obj.get("idUser").toString()));
                u.setNom(obj.get("nom").toString());
                u.setPrenom(obj.get("prenom").toString());
                //u.setDateNaiss(Date.parse(u.setDateNaiss(Date.parse())));
                u.setSexe(obj.get("sexe").toString());
                u.setAdresse(obj.get("adresse").toString());
                u.setEmail(obj.get("email").toString());
                u.setPassword(obj.get("password").toString());
                u.setRole(RoleUser.valueOf(obj.get("role").toString()));        
                u.setConfirmationCode(obj.get("confirmationCode").toString());
                u.setConfirmation(obj.get("confirmation").toString().equals("0")?false:true);
                u.setActive(obj.get("active").toString().equals("0")?false:true);
                System.out.println(u);               
                listUsers.add(u);
            }
        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return listUsers;

    }
    
    ArrayList<User> lstUser = new ArrayList<>();
    public User getUser(String email,String motDePass){ 
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Servers/user/getUser.php");  
        con.addArgument("email", email);
        con.addArgument("motDePass", motDePass);      
        con.addResponseListener(new ActionListener<NetworkEvent>() {
           @Override
           public void actionPerformed(NetworkEvent e) {
               String str = new String(con.getResponseData());//Récupération de la réponse du serveur
               System.out.println(str);//Affichage de la réponse serveur sur la console
               lstUser = parseListTaskJson(str);
           }
       });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return lstUser.get(0);
    }

}
