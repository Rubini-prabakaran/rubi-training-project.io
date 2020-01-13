package com.cognizant.truyum.Dao;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import com.cognizant.truyum.model.Cart;

import com.cognizant.truyum.model.MenuItem;

public class CartItemDaoCollectionImpl implements CartDao {
	private static HashMap<Long, Cart> userCarts;

	public CartItemDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<>();
		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		// instantiate menuItemDaoCollectionImpl and assign the MenuItemDao reference
		// variable menuItemDao
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		// get the menuItem using menuItemDao.getMenuItem(menuItemId) method
		MenuItem menuItem = menuItemDao.getmenuItem(menuItemId);
		if (userCarts.containsKey(userId)) {
			userCarts.get(userId).getMenuItemList().add(menuItem);
		} else {
			// create a new cart instance with new arrayList
			Cart cart = new Cart();
			ArrayList<MenuItem> menuItemList = new ArrayList<>();
			menuItemList.add(menuItem);
			cart.setMenuItemList(menuItemList);
			userCarts.put(userId, cart);
		}

	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		// List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		Cart cart = userCarts.get(userId);
		double total = 0.0f;
		if (cart == null || cart.getMenuItemList().isEmpty()) {
			throw new CartEmptyException();
		}
		List<MenuItem> menuItemList = cart.getMenuItemList();
		for (MenuItem menuItem : menuItemList) {
			total += menuItem.getPrice();
		}
		cart.setTotal(total);
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long MenuItemId) {
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == MenuItemId) {
				menuItemList.remove(i);
				return;
			}
		}
	}
}