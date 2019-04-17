package dao;

import entities.User;

public interface IDao<T>{
	
	public void insert(T user);
	public void delete(int user);
	public void update(T user);
	public void findAll();
	public void findById();

}
