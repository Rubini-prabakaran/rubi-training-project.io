package com.cognizant.movie.model;

import java.util.Date;


public class Movies {
	private long id;
	private String title;
	private long Gross;
	private boolean Active;
	private Date dateOfLaunch;
	private String Genre;
	private boolean hasTeaser;

	public Movies(long id, String title, long gross, boolean active, Date dateOfLaunch, String genre,
			boolean hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		Gross = gross;
		Active = active;
		this.dateOfLaunch = dateOfLaunch;
		Genre = genre;
		this.hasTeaser = hasTeaser;
	}

	public Movies() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getGross() {
		return Gross;
	}

	public void setGross(long gross) {
		Gross = gross;
	}

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public boolean isHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (Active ? 1231 : 1237);
		result = prime * result + ((Genre == null) ? 0 : Genre.hashCode());
		result = prime * result + (int) (Gross ^ (Gross >>> 32));
		result = prime * result + ((dateOfLaunch == null) ? 0 : dateOfLaunch.hashCode());
		result = prime * result + (hasTeaser ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movies other = (Movies) obj;
		if (Active != other.Active)
			return false;
		if (Genre == null) {
			if (other.Genre != null)
				return false;
		} else if (!Genre.equals(other.Genre))
			return false;
		if (Gross != other.Gross)
			return false;
		if (dateOfLaunch == null) {
			if (other.dateOfLaunch != null)
				return false;
		} else if (!dateOfLaunch.equals(other.dateOfLaunch))
			return false;
		if (hasTeaser != other.hasTeaser)
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", Gross=" + Gross + ", Active=" + Active + ", dateOfLaunch="
				+ dateOfLaunch + ", Genre=" + Genre + ", hasTeaser=" + hasTeaser + "]";
	}
}