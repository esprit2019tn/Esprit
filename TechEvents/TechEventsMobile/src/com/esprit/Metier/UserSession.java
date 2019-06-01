/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Metier;

import com.esprit.Entity.User;
import com.esprit.Service.ServiceUser;
import com.codename1.io.Preferences;
import com.codename1.properties.PreferencesObject;

/**
 *
 * @author AYMEN
 */
public class UserSession {
    
    private User user;

    public UserSession(User user) {
        this.user = user;
    }
    
    public static void createUserSession(User user){ 
        Preferences.set("email", user.getEmail());
        Preferences.set("motDePasse", user.getPassword());
    }
    
    
    public static User getUserSession(){ 
        User user=null;
        ServiceUser serviceUser =new ServiceUser();        
        String email;
        String motDePasse;
        email = Preferences.get("email","");
        motDePasse = Preferences.get("motDePasse","");
        if(!email.isEmpty() && !motDePasse.isEmpty())
            user =serviceUser.getUser(email,motDePasse);
        return  user;
    }
    
    public static void destroyUserSession(){ 
        Preferences.clearAll();
    }
    
    
        
    public static Boolean verifUserSession(){ 
        Boolean res=true;
            if(getUserSession()==null)
                res=false;          
        return res;
    }    
    
}
