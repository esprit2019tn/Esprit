/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techevents;

import Dao.UserDao;
import Entity.User;

/**
 *
 * @author AYMEN
 */
public class TechEvents {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        User user=new User("jeddy", "aymen", "tunis", "aymen@gmail.com", "123");
        UserDao userDao=new UserDao();
        userDao.insert(user);
    }
    
}
