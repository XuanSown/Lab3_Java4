package impl;

import dao.UserDAO;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import util.XJPA;

public class UserDAOImpl extends AbstractDAO<User, String> implements UserDAO {
	public UserDAOImpl() {
		super(User.class);
	}

	@Override
	public User findById(String id) {
		EntityManager em = XJPA.getEntityManager();
		try {
			// Sử dụng LEFT JOIN FETCH để tải luôn danh sách favorites
			// Ngay cả khi user không có favorite nào (LEFT JOIN)
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.favorites WHERE u.id = :id",
					User.class);
			query.setParameter("id", id);
			// Sử dụng getSingleResult vì ID là duy nhất
			return query.getSingleResult();
		} catch (NoResultException e) {
			// Không tìm thấy user thì trả về null
			return null;
		} finally {
			em.close(); // Luôn đóng EntityManager
		}
	}
}
