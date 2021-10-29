package com.wd.pattern.datastore;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;


public interface DatasourceInterface {
	
	public ObjectMapper getCartesianDatasource();
	public ObjectMapper setCartesianDatasource(Point2D point);
	public ArrayList<Point2D> getPointsFromPlaneSpace(Point2D point);
	
}
