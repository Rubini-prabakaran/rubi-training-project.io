package com.cognizant.truyum.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.Dao.MenuItemDao;

import com.cognizant.truyum.Dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

/**
 * Servlet implementation class ShowEditMenuItemServlet
 */
@WebServlet("/ShowEditMenuItem")
public class ShowEditMenuItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowEditMenuItem() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		Long menuItemId = Long.parseLong(request.getParameter("id"));
		MenuItem menuItem = menuItemDao.getmenuItem(menuItemId);
		request.setAttribute("menuItem", menuItem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-menu-item.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
