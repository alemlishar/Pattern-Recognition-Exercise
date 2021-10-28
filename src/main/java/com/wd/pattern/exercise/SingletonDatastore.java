package com.wd.pattern.exercise;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonDatastore {

	static ConcurrentHashMap<String, List<Point2D>> CartesianSpacePoints = new ConcurrentHashMap<String, List<Point2D>>();
	private SingletonDatastore singletonDatastore;

	private SingletonDatastore() {

	}

	public SingletonDatastore SingletonDatastore() {
		if(CartesianSpacePoints == null)
			synchronized(SingletonDatastore.class) {
				if(CartesianSpacePoints == null)
					singletonDatastore = new SingletonDatastore();
			}
		return singletonDatastore;
	}

	public ConcurrentHashMap<String, List<Point2D>> CartesianDatastore() {

		return CartesianSpacePoints;
	}
}
