package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Account;

/**
 * Servlet implementation class SignUpControl
 */
@WebServlet(name = "SignUpControl", urlPatterns = {"/signup"})
public class SignUpControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String userName = request.getParameter("user");
		String password = request.getParameter("pass");
		String re_Pass = request.getParameter("repass");
		DAO dao = new DAO();
		Account acc = dao.checkAccountExist(userName);

		if (!password.equals(re_Pass)) {
			request.setAttribute("mess", "repass wrong");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			
		} else {
			if (acc == null) {
				request.setAttribute("mess", "Sign up successfully");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				dao.signup(userName, password);

			} else {
				request.setAttribute("mess", "User has exist");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
