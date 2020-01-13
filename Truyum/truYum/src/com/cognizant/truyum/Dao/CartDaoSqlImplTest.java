package com.cognizant.truyum.Dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {
	public static void testaddCartItem() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long userId = 1;
		System.out.println("Enter the Cart Id to Add");
		long menuItemId = Long.parseLong(bf.readLine());
		new CartDaoSqlImpl().addCartItem(userId, menuItemId);
	}

	public static void testremoveCartItem() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long userId = 1;
		System.out.println("Enter the Cart Id to remove");
		long MenuItemId = Long.parseLong(bf.readLine());
		new CartDaoSqlImpl().removeCartItem(userId, MenuItemId);
	}

	public static void testgetAllCartItems() throws CartEmptyException {
		long userId = 1;
		Cart cart = new CartDaoSqlImpl().getAllCartItems(userId);
		List<MenuItem> menuItemList = cart.getMenuItemList();
		double total = cart.getTotal();
		DecimalFormat df = new DecimalFormat("#.00");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("%-15s%-15s%-15s%-20s%-15s%-15s\n", "NAME", "PRICE", "ACTIVE", "DATE_OF_LAUNCH", "CATEGORY",
				"FREEDELIVERY");
		String FreeDelivery;
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getFreeDelivery() == true) {
				FreeDelivery = "Yes";
			} else {
				FreeDelivery = "No";
			}
			String Active;
			if (menuItem.getActive() == true) {
				Active = "Yes";
			} else {
				Active = "No";
			}
			System.out.format("%-15s%-15s%-15s%-20s%-15s%-15s\n", menuItem.getName(), df.format(menuItem.getPrice()),
					Active, sdf.format(menuItem.getDateOfLaunch()), menuItem.getCategory(), FreeDelivery);
		}
		System.out.println("Total=" + total);
	}

	public static void main(String[] args) throws IOException, ParseException, CartEmptyException {
		testaddCartItem();
		testremoveCartItem();
		testgetAllCartItems();
	}

}
