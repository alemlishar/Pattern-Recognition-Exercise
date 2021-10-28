package com.wd.pattern.exercise;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonDatastore {

	static ConcurrentHashMap<String, List<Point2D>> CartesianSpacePoints = new ConcurrentHashMap<String, List<Point2D>>();
	private static SingletonDatastore singletonDatastore;
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

	public ConcurrentHashMap<String, List<Point2D>> getCartesianDatastore() {

		return CartesianSpacePoints;
	}

	public int CartesianLineSegmentCounter() {

		return ++lineSegmentCounter;
	}
}
