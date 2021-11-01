package com.wd.pattern.domain;

import javax.validation.constraints.NotNull;

public class Point {
	
	private double x;
	private double Y;	

	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Point( double x, double y) {
		super();
		this.x = x;
		Y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}
	
}

