package com.cognizant.truyum.Dao;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {
	public static void testAddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartItemDaoCollectionImpl();
		cartDao.addCartItem(1, 2L);
		cartDao.addCartItem(1, 5L);
		cartDao.addCartItem(2, 1L);
		cartDao.addCartItem(2, 3L);

		Cart menuItemListCustomer = cartDao.getAllCartItems(1);
		for (MenuItem menuItem : menuItemListCustomer.getMenuItemList()) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() throws CartEmptyException {
		CartDao cartDao = new CartItemDaoCollectionImpl();
		System.out.println("Item list for Customer after Remove");
		try {
			cartDao.removeCartItem(1, 2l);
			cartDao.removeCartItem(1, 5L);
			cartDao.removeCartItem(1, 3l);
			Cart menuItemListCustomer = cartDao.getAllCartItems(2);
			for (MenuItem menuItem : menuItemListCustomer.getMenuItemList()) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			// System.out.println(e.getMessage());
		}
	}

	public static void testGetAllCartItems() {

	}

	public static void main(String[] args) throws CartEmptyException {
		testAddCartItem();
		testRemoveCartItem();
	}
}
