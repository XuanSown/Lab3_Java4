package impl;

import dao.FavoriteDAO;
import entity.Favorite;

public class FavoriteDAOImpl extends AbstractDAO<Favorite, Long> implements FavoriteDAO {
	public FavoriteDAOImpl() {
		super(Favorite.class);
	}
}
