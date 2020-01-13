package com.cognizant.truyum.Dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
	public static void testGetmenuItemListAdmin() {
		// System.out.println("Item list for Admin");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
			// System.out.println(new
			// DateUtil().convertToString(menuItem.getDateOfLaunch()));
		}

	}

	public static void testGetMenuItemListCustomer() {
		// System.out.println("Item List for Customer");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);

		}

	}

	public static void testModifyMenuItem() {
		// create an instance for menu item with id matching any one of the menu item
		// already added to the menulistitem
		MenuItem item = new MenuItem(5L, "Biriyani", 52.00f, true, new DateUtil().convertToDate("02/12/2017"),
				"Main Course", true);
		// instantiate menuDaocollection and assign it to menuDao reference variable
		// mwnuitemDao
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		// invoke MenuItemDao.modifyMenuItem(menuItem)
		menuItemDao.modifyMenuItem(item);
		// System.out.println("Modified List ***");
		testGetmenuItemListAdmin();
		MenuItem modified_item = menuItemDao.getmenuItem(item.getId());
		System.out.println("Modified ITEM Detail\n" + modified_item);
	}

	public static void main(String[] args) {
		testGetmenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
	}
}
