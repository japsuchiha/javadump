/*
 * @(#)City.java        1.0 2007/01/23
 *
 * Copyright Ben Zoller (University of Maryland, College Park), 2007
 * All rights reserved. Permission is granted for use and modification in CMSC420 
 * at the University of Maryland.
 */
package cmsc420.geometry;

import java.awt.geom.Point2D;


/**
 * City class is an analogue to a real-world city in 2D space. Each city
 * contains a location ((x,y) coordinates), name, radius, and color.
 * <p>
 * Useful <code>java.awt.geom.Point2D</code> methods (such as distance()) can
 * be utilized by calling toPoint2D(), which creates a Point2D copy of this
 * city's location.
 */
public class City extends Geometry {
	/** name of this city */
	protected String name;

	/** 2D coordinates of this city */
	protected Point2D.Float local;
	protected Point2D.Float remote;
	/** radius of this city */
	protected int radius;

	/** color of this city */
	protected String color;

	/**
	 * Constructs a city.
	 * 
	 * @param name
	 *            name of the city
	 * @param x
	 *            X coordinate of the city
	 * @param y
	 *            Y coordinate of the city
	 * @param radius
	 *            radius of the city
	 * @param color
	 *            color of the city
	 */
	
	
	public City(final String name, final int x, final int y, final int radius,
			final String color, final int localx, final int localy) {
		this.name = name;
		remote = new Point2D.Float(x, y);
		local = new Point2D.Float(localx, localy);
		this.radius = radius;
		this.color = color;
		
	}
	
	public City(final City city) {
		this.name = city.name;
		
		this.local = city.local;
		this.remote = city.remote;
		this.radius = city.radius;
		this.color = city.color;
	}

	/**
	 * Gets the name of this city.
	 * 
	 * @return name of this city
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the X coordinate of this city.
	 * 
	 * @return X coordinate of this city
	 */
	public int getRemoteX() {
		return (int) remote.x;
	}
	
	public int getLocalX() {
		return (int) local.x;
	}

	/**
	 * Gets the Y coordinate of this city.
	 * 
	 * @return Y coordinate of this city
	 */
	public int getRemoteY() {
		return (int) remote.y;
	}
	
	public int getLocalY() {
		return (int) local.y;
	}

	/**
	 * Gets the color of this city.
	 * 
	 * @return color of this city
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Gets the radius of this city.
	 * 
	 * @return radius of this city.
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Determines if this city is equal to another object. The result is true if
	 * and only if the object is not null and a City object that contains the
	 * same name, X and Y coordinates, radius, and color.
	 * 
	 * @param obj
	 *            the object to compare this city against
	 * @return <code>true</code> if cities are equal, <code>false</code>
	 *         otherwise
	 */
	public boolean equals(final Object obj) {
		if (obj == this)
			return true;
		if (obj != null && (obj.getClass().equals(this.getClass()))) {
			City c = (City) obj;
			return (local.equals(c.local)&& remote.equals(c.remote) && (radius == c.radius) && color
					.equals(c.color));
		}
		return false;
	}

	/**
	 * Returns a hash code for this city.
	 * 
	 * @return hash code for this city
	 */
	public int hashCode() {
		int hash = 12;
		hash = 37 * hash + name.hashCode();
		hash = 37 * hash + remote.hashCode();
		hash = 37 * hash + local.hashCode();
		hash = 37 * hash + radius;
		hash = 37 * hash + color.hashCode();
		return hash;
	}

	/**
	 * Returns an (x,y) representation of the city. Important: casts the x and y
	 * coordinates to integers.
	 * 
	 * @return string representing the location of the city
	 */
	public String getLocationString() {
		final StringBuilder location = new StringBuilder();
		location.append("(");
		location.append(getRemoteX());
		location.append(",");
		location.append(getRemoteY());
		location.append(")");
		return location.toString();

	}

	/**
	 * Returns a Point2D instance representing the City's location.
	 * 
	 * @return location of this city
	 */
	
	
	public Point2D localToPoint2D() {
		return new Point2D.Float(local.x, local.y);
	}
	
	public Point2D remoteToPoint2D() {
		return new Point2D.Float(remote.x, remote.y);
	}
	
	public String toString() {
		return getLocationString();
	}

	@Override
	public int getType() {
		return POINT;
	}
}