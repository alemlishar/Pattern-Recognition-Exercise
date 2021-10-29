package com.wd.pattern.exercise.service;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.wd.pattern.domain.Point;
import com.wd.pattern.domain.Point2DPlane;
import com.wd.pattern.exercise.SingletonDatastore;

@Service
public class PatternRecognitionServiceImpl implements PatterRecognitionService{

	/**
	 * @apiNote	Create New point in Data storage
	 * @param Point with cordinates x and y
	 * @return datastorage as key value LineSegmentIdentifier, List of Points  
	 */

	/**
	 * @apiNote	Delete all Points in a plane Space
	 * @param Point with cordinates x and y
	 * @return true or false  
	 */
	@Override
	public boolean DeleteCartesianSpacePoints() {
		// TODO Auto-generated method stub
		if(SingletonDatastore.getInstance().getCartesianDatastore().size() != 0) {
			SingletonDatastore.getInstance().getCartesianDatastore().clear();
			return true;
		}else 
			return false;
	}

	/**
	 * @apiNote	get all LineSegmentsIdentifier
	 * @return get all LineSegmentIdentifier  
	 */
	@Override
	public List<String> getAllLineSegmentIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @apiNote	Create New point in Data storage
	 * @param Point with cordinates x and y
	 * @return datastorage as key value LineSegmentIdentifier, List of Points  
	 */
	@Override
	public List<Point> getSpecificLineSegment(String LineIdentifier) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @apiNote	Calculate the slope of the new Point along with every List Of the points in Line segment
	 * @param New Point with cordinates x and y
	 * @return success response True or False
	 */
	@Override
	public boolean pointExistInLineSegment(Point point) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @apiNote	Calculate the slope of the new Point along with every List Of the points in Line segment
	 * @param New Point List with coordinates x and y
	 * @return success response True or False
	 */
	@Override
	public boolean addPointInSinglelineSegment(List<Point> pointList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ConcurrentHashMap<String, List<Point>> CreatePoint(Point point) {

		ArrayList<Point> p = new ArrayList<Point>();
		p.add(point);
		ConcurrentHashMap<String, List<Point>> dataStore = SingletonDatastore.getInstance().getCartesianDatastore();
		dataStore.put("lineSegment" + SingletonDatastore.getInstance().CartesianLineSegmentCounter() + 1,p);
		return dataStore;
	}

	@Override
	public ConcurrentHashMap<String, List<Point>> getAllSpacePoints() {
		// TODO Auto-generated method stub
		ConcurrentHashMap<String, List<Point>> dataStore = SingletonDatastore.getInstance().getCartesianDatastore();
		return dataStore;
	}
}
