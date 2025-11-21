package servlet;

import java.io.IOException;

import dao.UserDAO;
import entity.User;
import impl.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/favorites-by-use")
public class FavoriteByUserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public FavoriteByUserServlet() {
		super();
		this.userDAO = new UserDAOImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fullname = req.getParameter("fullname"); // lay tham so tu URL
		if (fullname != null && !fullname.trim().isEmpty()) {
			User user = this.userDAO.findByFullname(fullname);
			if (user != null) {
				req.setAttribute("user", user);
			}
		}
		req.getRequestDispatcher("/views/favoritesByUser.jsp").forward(req, resp);
	}
}
