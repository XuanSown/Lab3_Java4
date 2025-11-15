package impl;

import dao.ShareDAO;
import entity.Share;

public class ShareDAOImpl extends AbstractDAO<Share, Long> implements ShareDAO {
	public ShareDAOImpl() {
		super(Share.class);
	}
}
