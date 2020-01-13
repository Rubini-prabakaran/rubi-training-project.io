package com.cognizant.truyum.Dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	public static void display(List<MenuItem> menuItemList) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("##,###.00");
		System.out.format("\n%5s%25s%15s%15s%15s%15s%15s", "ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH",
				"CATEGORY", "FREE DELIVERY");
		for (MenuItem menuItem : menuItemList) {
			System.out.format("\n%5s%25s%15s%15s%15s%15s%15s", menuItem.getId(), menuItem.getName(),
					df.format(menuItem.getPrice()), menuItem.getActive(), sdf.format(menuItem.getDateOfLaunch()),
					menuItem.getCategory(), menuItem.getFreeDelivery());

		}
	}

	public static void testGetmenuItemListAdmin() {
		ArrayList<MenuItem> menuItemListAdmin = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
		System.out.println("Admin");
		display(menuItemListAdmin);
	}

	public static void testGetmenuItemListCustomer() {
		List<MenuItem> menuItemListCustomer = new MenuItemDaoSqlImpl().getMenuItemListCustomer();
		System.out.println("Customer");
		display(menuItemListCustomer);
	}

	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(1L, "AB", 1256.23f, true, new DateUtil().convertToDate("15/03/2017"),
				"Dessert", true);
		new MenuItemDaoSqlImpl().modifyMenuItem(menuItem);

	}

	public static void testGetmenuItem() {
		System.out.println("\n Enter the ID:");
		long menuItemId = 3;
		MenuItem menu_item = new MenuItemDaoSqlImpl().getmenuItem(menuItemId);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.format("\n" + "%5s%25s%15s%15s%20s%15s%15s", menu_item.getId(), menu_item.getName(),
				df.format(menu_item.getPrice()), menu_item.getActive(), sdf.format(menu_item.getDateOfLaunch()),
				menu_item.getCategory(), menu_item.getFreeDelivery());
	}

	public static void main(String[] args) {

		ConnectionHandler.getConnection();
		testModifyMenuItem();
		testGetmenuItemListAdmin();
		testGetmenuItemListCustomer();
		testGetmenuItem();
	}

}
