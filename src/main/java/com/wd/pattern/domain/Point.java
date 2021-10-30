package com.wd.pattern.domain;

import javax.validation.constraints.NotNull;

public class Point {

	@NotNull
	private String x;
	@NotNull
	private String y;


	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Point(@NotNull String x, @NotNull String y) {
		super();
		this.x = x;
		this.y = y;
	}

	public String getX() {
		return x;
	}


	public void setX(String x) {
		this.x = x;
	}


	public String getY() {
		return y;
	}


	public void setY(String y) {
		this.y = y;
	}

}

