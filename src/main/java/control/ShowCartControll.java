package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Product;

/**
 * Servlet implementation class ShowCartControll
 */
@WebServlet(urlPatterns = "/show")
public class ShowCartControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowCartControll() {
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
		Cookie arr[] = request.getCookies();
		//Cookie cookie = null;
		DAO dao = new DAO();
	//	String pid = request.getParameter("pid");
		List<Product> list = new ArrayList<Product>();
		for (Cookie o : arr) {
			if (o.getName().equals("id")) {
				String txt[] = o.getValue().split(""+"null");
				for (String s : txt) {
					list.add(dao.getProductByID(s));
				}
			}
		}
		// t2
		for (int i = 0; i < list.size(); i++) {
			int count = 1;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getId() == list.get(j).getId()) {
					count++;
					list.remove(j);
					j--;
					list.get(i).setAmount(count);
				}
			}
		}

		double total = 0;
		for (Product product : list) {
			total += product.getAmount() * product.getPrice();
		}
		double totalP = total - (total * 0.1);
		
//		if(pid != null) {
//			for (Cookie o : arr) {
//				if(o.getName().equals("id")) {			
//					o.setMaxAge(0);
//					response.addCookie(o);
//					list.remove(dao.getProductByID(pid));
//				}
//				
//			}
//		}
		
		request.setAttribute("total", total);
		request.setAttribute("totalP", totalP);
		request.setAttribute("list", list);
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
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
