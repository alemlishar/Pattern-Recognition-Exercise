package com.wd.pattern.exercise.domain;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Space {
	private ConcurrentHashMap<String, List<Point2D>> cartesian = new ConcurrentHashMap<String, List<Point2D>>();

	public ConcurrentHashMap<String, List<Point2D>> getCartesian() {
		return cartesian;
	}

	public void setCartesian(ConcurrentHashMap<String, List<Point2D>> cartesian) {
		this.cartesian = cartesian;
	}

}
