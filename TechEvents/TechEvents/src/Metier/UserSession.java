/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Entity.User;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

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
        Preferences userPreferences = Preferences.userRoot();
        userPreferences.putInt("id", user.getId());
        userPreferences.put("nom", user.getNom());
        userPreferences.put("prenom", user.getPrenom());
        userPreferences.put("email", user.getEmail());
    }
    
    
    public static User getUserSession(){ 
        User user=new User();
        Preferences userPreferences = Preferences.userRoot();
        user.setId(userPreferences.getInt("id",0));
        user.setNom(userPreferences.get("nom",""));
        user.setPrenom(userPreferences.get("prenom",""));
        user.setEmail(userPreferences.get("email",""));

        return  user;
    }
    
    public static void destroyUserSession() throws BackingStoreException{ 
        Preferences userPreferences = Preferences.userRoot();
        userPreferences.clear();
    }
    
    
        
    public static Boolean verifUserSession() throws BackingStoreException{ 
        Boolean res=true;
            if(getUserSession().getNom().equals("")||getUserSession().getNom().equals(""))
                res=false;          
        return res;
    }    
    
    
    
}
