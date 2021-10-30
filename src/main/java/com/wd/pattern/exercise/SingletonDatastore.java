package com.wd.pattern.exercise;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import com.wd.pattern.domain.Point;

public class SingletonDatastore {

	static ConcurrentHashMap<Integer, ArrayList<Point>> CartesianSpacePoints = new ConcurrentHashMap<Integer, ArrayList<Point>>();
	private static SingletonDatastore singletonDatastore;
	static int lineSegmentCounter = 0;

	private SingletonDatastore() {

	}
	public static SingletonDatastore getInstance() {
		
		if(singletonDatastore == null)
			singletonDatastore = new SingletonDatastore();
		return singletonDatastore;
	}

	public static ConcurrentHashMap<Integer, ArrayList<Point>> getCartesianDatastore() {

		return CartesianSpacePoints;
	}

	public static int SetCartesianLineSegmentCounter(ConcurrentHashMap<Integer, ArrayList<Point>> CartesianSpacePoints) {

		lineSegmentCounter = CartesianSpacePoints.size() + 1;
		return lineSegmentCounter;
	}

	public static int GetCartesianLineSegmentCounter() {

		return CartesianSpacePoints.size();
	}

	public static void StorePointToDataStore(Point point, int lineIndex) {
		SingletonDatastore.getCartesianDatastore().get(lineIndex).add(point);
	}

	public static void storeLineToDataStore(ArrayList<Point> linesPoint) {
		SingletonDatastore.getCartesianDatastore().put(SingletonDatastore.GetCartesianLineSegmentCounter() + 1, linesPoint);
	}
}
