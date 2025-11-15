package servlet;

import java.io.IOException;
import java.util.List;

import dao.FavoriteDAO;
import entity.Favorite;
import impl.FavoriteDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/all-favorites")
public class AllFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FavoriteDAO favoriteDAO;

	public AllFavoritesServlet() {
		super();
		this.favoriteDAO = new FavoriteDAOImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Favorite> favorites = this.favoriteDAO.findAll();
		req.setAttribute("favorites", favorites);
		req.getRequestDispatcher("/views/allFavorites.jsp").forward(req, resp);
	}
}