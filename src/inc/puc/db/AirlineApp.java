package inc.puc.db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AirlineApp, responsible for receiving request
 * from the client. It also invokes the DAO to get a list of items from the
 * database, saves this list as an attribute in the request, and then forwards
 * the request to a JSP page.
 * 
 * @author Joshua Riley
 */

@WebServlet("/")
public class AirlineApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AirlineApp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws jakarta.servlet.ServletException, IOException {
		try {
			listCity(request, response);
			// System.out.println(request.getAttribute("listCity")); --> for debugging
			// purposes
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listCity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {
		CityDAO dao = new CityDAO();

		try {

			List<City> listCity = dao.list();
			request.setAttribute("listCity", listCity);
			request.getRequestDispatcher("/index.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		try {

			listCity(request, response);
			String city = request.getParameter("city");
			request.getSession().setAttribute("city", city);
			response.sendRedirect("departureflight.jsp");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
