package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Product;

/**
 * Servlet implementation class ShowCartControll
 */
@WebServlet(urlPatterns = "/show")
public class AddToCartControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Product> list = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartControll() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//	//	Cookie arr[] = request.getCookies();
//		PrintWriter out = response.getWriter();
//		DAO dao = new DAO();
//		Cart cart = new Cart();
//		String id = request.getParameter("id");
//		Product product = dao.getProductByID(id);
//		cart.addToCart(product);
//		List<Product> list = cart.getList();
//
////		String del = request.getParameter("del");
////		for (Cookie o : arr) {
////			if (o.getName().equals("id")) {
////				String txt[] = o.getValue().split("");
////				for (String s : txt) {
////					list.add(dao.getProductByID(s));
////				}
////			}
////		}
////		// t2
////		for (int i = 0; i < list.size(); i++) {
////			int count = 1;
////			for (int j = i + 1; j < list.size(); j++) {
////				if (list.get(i).getId() == list.get(j).getId()) {
////					count++;
////					list.remove(j);
////					j--;
////					list.get(i).setAmount(count);
////				}
////			}
////		}
////
////		double total = 0;
////		for (Product product : list) {
////			total += product.getAmount() * product.getPrice();
////		}
////		double totalP = total - (total * 0.1);
//
//
////		request.setAttribute("total", total);
////		request.setAttribute("totalP", totalP);
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("Cart.jsp").forward(request, response);

		response.setContentType("text/html;charset=UTF-8");	
		try (PrintWriter out = response.getWriter()) {
		HttpSession session = request.getSession();
		ArrayList<Product> cart_list = (ArrayList<Product>) session.getAttribute("list");
		ArrayList<Product> list = new ArrayList<>();
		int id = Integer.parseInt(request.getParameter("id"));
		//Cart cm = new Cart();
		Product cm = new Product();
		cm.setId(id);
		cm.setAmount(1);
		
		
		if (cart_list == null) {
			list.add(cm);
			session.setAttribute("list", list);
			response.sendRedirect("Cart.jsp");
		} else {
			list = cart_list;

			boolean exist = false;
			
			for (Product c : cart_list) {
				if (c.getId() == id) {
					exist = true;
					c.setAmount(c.getAmount() + 1);
					response.sendRedirect("Cart.jsp");
					// out.println("<h3 style='color:crimson; text-align: center'>Item Already in
					// Cart. <a href='Cart.jsp'>GO to Cart Page</a></h3>");
				}
				
				
			}
			
			
			if (!exist) {
				list.add(cm);
				response.sendRedirect("Cart.jsp");
			}
		}

		double total = 0;
		for (Product c : list) {
			total += c.getAmount() * c.getPrice();
			request.setAttribute("total", total);	
		}

		double totalP = total - (total * 0.1);
		request.setAttribute("totalP", totalP);

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
