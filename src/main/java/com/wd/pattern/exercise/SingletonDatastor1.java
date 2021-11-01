package com.wd.pattern.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wd.pattern.domain.Point;

public class SingletonDatastor1 {

	static ArrayList<List<String>> CartesianSpacePoints = new ArrayList<List<String>>();
	private static SingletonDatastor1 SingletonDatastor1;
	static int lineSegmentCounter = 0;
	final static Logger logger = LoggerFactory.getLogger(SingletonDatastor1.class);
	private SingletonDatastor1() {

	}
	public static SingletonDatastor1 getInstance() {

		if(SingletonDatastor1 == null)
			SingletonDatastor1 = new SingletonDatastor1();
		return SingletonDatastor1;
	}

	public static ArrayList<List<String>> getCartesianDatastore() {

		return CartesianSpacePoints;
	}

	public static int SetCartesianLineSegmentCounter(int counter) {
		lineSegmentCounter = counter + 1;
		logger.info("Line Segment Counter" + lineSegmentCounter);
		return lineSegmentCounter;
	}

	public static int GetCartesianLineSegmentCounter() {
		logger.info("Line Segment Counter" + lineSegmentCounter);
		return lineSegmentCounter;
	}

	public static void StorePointToExistedDataStore(Point point, int lineIndex) {

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
	}
}
