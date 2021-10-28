package com.wd.pattern.controller.datastore;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DatasourceInterfaceImpl implements DatasourceInterface{

	private static Jackson2ObjectMapperBuilder builder;
	private static ObjectMapper datasourceMapper;
	static ConcurrentHashMap<String, List<Point2D>> CartesianSpacePoints = new ConcurrentHashMap<String, List<Point2D>>();

	
	@Override
	public ObjectMapper getCartesianDatasource() {

		return datasourceMapper;
	}

	@Override
	public ObjectMapper setCartesianDatasource(Point2D point) {
		try {
			datasourceMapper.writeValueAsBytes(CartesianSpacePoints);
		} catch (JsonProcessingException e) {
						e.printStackTrace();
		}

		return datasourceMapper;
	}

	@Override
	public ArrayList<Point2D> getPointsFromPlaneSpace(Point2D point) {
		
		
		ArrayList<Point2D> points;
		return null;
	}

}
