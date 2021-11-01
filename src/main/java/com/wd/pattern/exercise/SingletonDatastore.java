package com.wd.pattern.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wd.pattern.domain.Point;

public class SingletonDatastore {

	static ConcurrentHashMap<String, List<Point>> CartesianSpacePoints = new ConcurrentHashMap<String, List<Point>>();
	private static SingletonDatastore singletonDatastore;
	static int lineSegmentCounter = 0;
	//double [] a = {5.5,4.5,6.4};
	//String bb[] = {3,4,5,6};
	final static Logger logger = LoggerFactory.getLogger(SingletonDatastore.class);

	private SingletonDatastore() {

	}
	public static SingletonDatastore getInstance() {

		if(singletonDatastore == null)
			singletonDatastore = new SingletonDatastore();
		return singletonDatastore;
	}

	public static ConcurrentHashMap<String, List<Point>> getCartesianDatastore() {

		return CartesianSpacePoints;
	}

	public static int GetCartesianLineSegmentCounter() {

		return CartesianSpacePoints.size();
	}

	
	
	public static void StorePointToDataStore(Point point, int lineIndex) {
	//	SingletonDatastore.getCartesianDatastore().get(lineIndex).add(point.getX() + "," + point.getY());
	}

	public static void storeLineToDataStore(ArrayList<Point> linesPoint) {
		//SingletonDatastore.getCartesianDatastore().
	}


	/*public static void StorePointToExistedDataStore(Point point, int lineIndex) {

		List<String> newPoint = new ArrayList<String>();
		newPoint.add(point.getX() + "," + point.getY());
		getCartesianDatastore().get(lineIndex).add(point.getX() + "," + point.getY());
		logger.info("----Line Segment Counter---" + lineSegmentCounter);
	}

	public static void storeNewLineToDataStore(List<String> linesPoint) {
		
		logger.info("the value to be added in data store" + linesPoint.get(0));
		getCartesianDatastore().add(linesPoint);
		logger.info("data store" + getCartesianDatastore().get(0).toString());

	}

	public static void storePointToDataStore(List <String> linesPoint) {
		getCartesianDatastore().add(linesPoint);
	}*/
}
