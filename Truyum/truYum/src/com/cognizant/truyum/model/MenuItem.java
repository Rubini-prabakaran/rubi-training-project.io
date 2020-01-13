package com.cognizant.truyum.model;

import java.util.Date;

import com.cognizant.truyum.util.DateUtil;

public class MenuItem {

	private Long id;
	private String name;
	private Float price;
	private Boolean active;
	private Date dateOfLaunch;
	private String Category;
	private Boolean freeDelivery;

	public MenuItem(Long id, String name, Float price, Boolean active, Date dateOfLaunch, String Category,
			Boolean freeDelivery) {

		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.Category = Category;
		this.freeDelivery = freeDelivery;

	}

	public MenuItem() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public Boolean getFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(Boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (dateOfLaunch == null) {
			if (other.dateOfLaunch != null)
				return false;
		} else if (!dateOfLaunch.equals(other.dateOfLaunch))
			return false;
		if (freeDelivery == null) {
			if (other.freeDelivery != null)
				return false;
		} else if (!freeDelivery.equals(other.freeDelivery))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
				+ new DateUtil().convertToString(dateOfLaunch) + ", Category=" + Category + ", freeDelivery="
				+ freeDelivery + "]";
	}

}
