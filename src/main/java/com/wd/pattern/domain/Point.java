package com.wd.pattern.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public final class Point {

	

	@NotNull
	private Double x;

	@NotNull
	private Double y;

	
	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Point(@NotNull Double x, @NotNull Double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

}
