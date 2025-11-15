package impl;

import java.util.List;

import dao.FavoriteDAO;
import entity.Favorite;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import util.XJPA;

public class FavoriteDAOImpl extends AbstractDAO<Favorite, Long> implements FavoriteDAO {
	public FavoriteDAOImpl() {
		super(Favorite.class);
	}

	@Override
	public List<Favorite> findAll() {
		EntityManager em = XJPA.getEntityManager();
		try {
			String jpql = "SELECT f FROM Favorite f JOIN FETCH f.user JOIN FETCH f.video";
			TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
}
