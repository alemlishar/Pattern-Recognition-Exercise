package com.wd.pattern.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Point {
	
	@NotNull
	@NotBlank
	private String x;
	@NotNull
	@NotEmpty
	private String Y;	

	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Point( String x, String y) {
		super();
		this.x = x;
		Y = y;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return Y;
	}

	public void setY(String y) {
		Y = y;
	}
	
}

