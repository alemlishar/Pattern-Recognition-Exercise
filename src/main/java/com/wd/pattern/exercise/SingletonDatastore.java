package com.wd.pattern.exercise;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import com.wd.pattern.domain.Point;
import com.wd.pattern.domain.Point2DPlane;

public class SingletonDatastore {

	static ConcurrentHashMap<String, List<Point>> CartesianSpacePoints = new ConcurrentHashMap<String, List<Point>>();
	private static SingletonDatastore singletonDatastore = new SingletonDatastore();
	static int lineSegmentCounter = 1;

	private SingletonDatastore() {

	}

	public static SingletonDatastore getInstance() {
		if(singletonDatastore == null)
			synchronized(SingletonDatastore.class) {
				if(singletonDatastore == null)
					singletonDatastore = new SingletonDatastore();
			}
		return singletonDatastore;
	}

	public ConcurrentHashMap<String, List<Point>> getCartesianDatastore() {

		return CartesianSpacePoints;
	}

	public int CartesianLineSegmentCounter() {

		return ++lineSegmentCounter;
	}

	public void StorePointToDataStore(@Valid Point point) {
		ArrayList<Point> LinePoints = new ArrayList<Point>();
		LinePoints.add(point);
		singletonDatastore.getInstance().getCartesianDatastore().put("Line"+CartesianLineSegmentCounter(), LinePoints);
	}
}
