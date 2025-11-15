package dao;

import java.util.List;

import entity.Share;

public interface ShareDAO {
	Share create(Share entity);

	Share update(Share entity);

	void deleteById(Long id);

	Share findById(Long id);

	List<Share> findAll();
}
