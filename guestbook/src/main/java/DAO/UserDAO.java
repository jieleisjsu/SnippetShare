package DAO;

import java.util.List;

import Entity.User;

public interface UserDAO {
	public boolean insert(User user);
	public List<User> findAll();
}
