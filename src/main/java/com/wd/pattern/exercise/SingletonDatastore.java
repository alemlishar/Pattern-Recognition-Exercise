package com.wd.pattern.exercise;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import com.wd.pattern.domain.Point;

public class SingletonDatastore {

	static ConcurrentHashMap<Integer, ArrayList<Point>> CartesianSpacePoints = new ConcurrentHashMap<Integer, ArrayList<Point>>();
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

	public static ConcurrentHashMap<Integer, ArrayList<Point>> getCartesianDatastore() {

		return CartesianSpacePoints;
	}

	public static int CartesianLineSegmentCounter() {

		return ++lineSegmentCounter;
	}

	public static int GetCartesianLineSegmentCounter() {

		return lineSegmentCounter;
	}

	public static void StorePointToDataStore(Point point) {
		ArrayList<Point> LinePoints = new ArrayList<Point>();
		LinePoints.add(point);
		SingletonDatastore.getCartesianDatastore().put(CartesianLineSegmentCounter(), LinePoints);
	}
	
	public static void storeLineToDataStore(ArrayList<Point> linesPoint) {
		SingletonDatastore.getCartesianDatastore().put(SingletonDatastore.GetCartesianLineSegmentCounter() + 1, linesPoint);
	}
}
