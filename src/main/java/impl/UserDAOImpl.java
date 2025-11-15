package impl;

import dao.UserDAO;
import entity.User;

public class UserDAOImpl extends AbstractDAO<User, String> implements UserDAO {
	public UserDAOImpl() {
		super(User.class);
	}
}
