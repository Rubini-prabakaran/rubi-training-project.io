package com.cognizant.truyum.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao {
	public static final String GET_ALL_MENUITEM_ADMIN = "select*from menu_item";

	public ArrayList<MenuItem> getMenuItemListAdmin() {
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_MENUITEM_ADMIN);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("Yes"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
				menuItemList.add(menuItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return menuItemList;
	}

	public static final String GET_ALL_MENUITEM_CUSTOMER = "select*from truyum.menu_item where menu_item.me_date_of_launch>curdate() and me_active='Yes';";

	public List<MenuItem> getMenuItemListCustomer() {

		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_MENUITEM_CUSTOMER);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("Yes"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
				menuItemList.add(menuItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return menuItemList;
	}

	public static final String EDIT_MENU_ITEM = "update menu_item set me_name=?,me_price=?,me_active=?,me_date_of_launch=?,me_category=?,me_free_delivery=? where me_id=?";

	public void modifyMenuItem(MenuItem menuItem) {

		// public boolean updateMenuItemDetails(int userId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			statement = connection.prepareStatement(EDIT_MENU_ITEM);

			statement.setString(1, menuItem.getName());
			statement.setFloat(2, menuItem.getPrice());
			statement.setString(3, menuItem.getActive() ? "Yes" : "No");
			statement.setDate(4, new DateUtil().convertToSqlDate(menuItem.getDateOfLaunch()));
			statement.setString(5, menuItem.getCategory());
			statement.setString(6, menuItem.getFreeDelivery() ? "Yes" : "No");
			statement.setLong(7, menuItem.getId());

			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Update not done");
		} finally {
			try {
				if (resultset != null) {
					resultset.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

			}
		}

	}

	public static final String GET_MENUITEM = "select*from truyum.menu_item where me_id=?";

	public MenuItem getmenuItem(Long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		MenuItem menu_item = null;
		try {
			preparedstatement = connection.prepareStatement(GET_MENUITEM);
			preparedstatement.setLong(1, menuItemId);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				menu_item = new MenuItem();
				menu_item.setId(resultset.getLong("me_id"));
				menu_item.setName(resultset.getString("me_name"));
				menu_item.setPrice(resultset.getFloat("me_price"));
				menu_item.setActive(resultset.getString("me_active").equals("Yes"));
				menu_item.setDateOfLaunch(resultset.getDate("me_date_of_launch"));
				menu_item.setCategory(resultset.getString("me_category"));
				menu_item.setFreeDelivery(resultset.getString("me_free_delivery").equals("Yes"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null) {
					resultset.close();
				}
				if (preparedstatement != null) {
					preparedstatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

			}
		}
		return menu_item;
	}
}
