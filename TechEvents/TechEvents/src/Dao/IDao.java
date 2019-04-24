package Dao;

import java.util.List;

public interface IDao<T>{
	
	public void insert(T obj);
	public void delete(int id);
	public void update(T obj);
	public List<T> findAll();
	public T findById(String id);
        public T findUser(String email,String password);

        

}
