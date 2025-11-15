package dao;

import java.util.List;

import entity.User;

public interface UserDAO {
	User create(User entity);

	User update(User entity);

	void deleteById(String id);

	User findById(String id);

	List<User> findAll();
}
