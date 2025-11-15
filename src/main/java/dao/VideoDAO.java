package dao;

import java.util.List;

import entity.Video;

public interface VideoDAO {
	Video create(Video entity);

	Video update(Video entity);

	void deleteById(String id);

	Video findById(String id);

	List<Video> findAll();
}
