package impl;

import dao.VideoDAO;
import entity.Video;

public class VideoDAOImpl extends AbstractDAO<Video, String> implements VideoDAO {
	public VideoDAOImpl() {
		super(Video.class);
	}
}
