package com.wd.pattern.domain;

import javax.validation.constraints.NotNull;

public class Point {
	
	@NotNull
	private double x;
	@NotNull
	private double Y;

	
	
	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Point(@NotNull double x, @NotNull double y) {
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

