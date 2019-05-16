/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.User;
import java.util.List;

/**
 *
 * @author AYMEN
 */
public  interface IDaoClient {
	
	public  void insert(User obj);
	public void delete(int id);
	public void update(User obj);
	public List<User> findAll();
	public User findById(int id);
        public User findUser(String email,String password);

        

   
}
