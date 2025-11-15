package dao;

import java.util.List;

import entity.Favorite;

public interface FavoriteDAO {
	Favorite create(Favorite entity);

	Favorite update(Favorite entity);

	void deleteById(Long id);

	Favorite findById(Long id);

	List<Favorite> findAll();
}
