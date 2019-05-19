/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Dao.UserDao;
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
    }
    
    
    public static User getUserSession(){ 
        UserDao userDao=new UserDao();
        Preferences userPreferences = Preferences.userRoot();
        int id;
        id = userPreferences.getInt("id",0);
        return  userDao.findById(id);
    }
    
    public static void destroyUserSession() throws BackingStoreException{ 
        Preferences userPreferences = Preferences.userRoot();
        userPreferences.clear();
    }
        
    public static Boolean verifUserSession() throws BackingStoreException{ 
        Boolean res=true;
            if(getUserSession()==null)
                res=false;          
        return res;
    }    
    
    
    
}
