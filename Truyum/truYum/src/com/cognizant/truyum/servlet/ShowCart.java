package com.cognizant.truyum.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.truyum.Dao.CartDao;
import com.cognizant.truyum.Dao.CartDaoSqlImpl;
import com.cognizant.truyum.Dao.CartEmptyException;

import com.cognizant.truyum.model.Cart;


/**
 * Servlet implementation class ShowCartServlet
 */
@WebServlet("/ShowCart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCart() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long userId=1l;
		CartDao cartDao=new CartDaoSqlImpl();
		try {
			Cart cart=cartDao.getAllCartItems(userId);
			request.setAttribute("cart",cart);
			//request.setAttribute("message",true);
			request.getRequestDispatcher("cart.jsp").forward(request,response);
		}catch(CartEmptyException e) {
			request.getRequestDispatcher("cart-empty.jsp").forward(request,response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
