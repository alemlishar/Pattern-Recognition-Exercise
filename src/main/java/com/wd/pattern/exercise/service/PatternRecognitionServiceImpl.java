package com.wd.pattern.exercise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
import com.wd.pattern.domain.Point;
import com.wd.pattern.exercise.SingletonDatastore;

@Service
public class PatternRecognitionServiceImpl implements PatterRecognitionService{


	/**
	 * @apiNote	Delete all Points in a plane Space
	 * @param Point with cordinates x and y
	 * @return true or false  
	 */
	@Override
	public boolean DeleteCartesianSpacePoints() {
		SingletonDatastore.getInstance();
		// TODO Auto-generated method stub
		if(SingletonDatastore.GetCartesianLineSegmentCounter() != 0) {
			SingletonDatastore.getCartesianDatastore().clear();
			return true;
		}else 
			return false;
	}

	/**
	 * @apiNote	get all LineSegmentsIdentifier
	 * @return get all LineSegmentIdentifier  
	 */
	@Override
	public ConcurrentHashMap<String, ArrayList<Point>> getLineSegmentsHavingAtleast(int limit) {

		ConcurrentHashMap<String, ArrayList<Point>> selectedLineSegments = new ConcurrentHashMap<String, ArrayList<Point>>() ;
		for(int i = 1; i<SingletonDatastore.GetCartesianLineSegmentCounter(); i++) {

			if(SingletonDatastore.getCartesianDatastore().get(i).size() > limit)
				selectedLineSegments.put("Line Segment" + selectedLineSegments.size()+1,SingletonDatastore.getCartesianDatastore().get(i));
		}
		return selectedLineSegments;
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
	 * @complexity O(K) < O(n)    k constants, n number of points
	 * @ to be improved
	 */
	@Override
	public boolean AddpointAsLineSegment(Point point) {
		// TODO Auto-generated method stub
		ArrayList<Point> lineSegment = new ArrayList<Point>();
		SingletonDatastore.getInstance();
		System.out.println("size of datastore" + SingletonDatastore.GetCartesianLineSegmentCounter() +
						"point" + point.getX() + point.getY());
		/*if(SingletonDatastore.GetCartesianLineSegmentCounter() >= 0)
			for(int i = 0; i < SingletonDatastore.GetCartesianLineSegmentCounter(); i++) {
				System.out.println("size of datastore" + SingletonDatastore.GetCartesianLineSegmentCounter() +
						"line points" + SingletonDatastore.getCartesianDatastore().get(i).size());
				//get any point from the line segment, atleast one exist get(0)....since it inserted in datastore space
				boolean value = VerifyPointsInline(point, SingletonDatastore.getCartesianDatastore().get(i).get(0));
				if(value) {
					lineSegment.add(point);
					SingletonDatastore.getCartesianDatastore().get(i).add(point);
					SingletonDatastore.SetCartesianLineSegmentCounter();
					break; 
				}
			}*/
		//if(lineSegment.size() == 0) {
			lineSegment.add(point);
			SingletonDatastore.storeLineToDataStore(lineSegment);
		//}
		return SingletonDatastore.getCartesianDatastore().size() > 0;
	}


	private  boolean VerifyPointsInline(Point p1, Point p2) {
		return	Double.compare(Double.parseDouble(p2.getY()) * 1/Double.parseDouble(p1.getY()),
								Double.parseDouble(p2.getY()) * 1/ Double.parseDouble(p1.getX())) == 0?
								true:false;
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

	/**
	 * to be improved
	 */
	@Override
	public ConcurrentHashMap<Integer, ArrayList<Point>> CreatePoint(Point point) {

		ArrayList<Point> p = new ArrayList<Point>();
		p.add(point);
		SingletonDatastore.getInstance();
		ConcurrentHashMap<Integer, ArrayList<Point>> dataStore = SingletonDatastore.getCartesianDatastore();
		dataStore.put(SingletonDatastore.GetCartesianLineSegmentCounter() + 1, p);
		return dataStore;
	}


	/**
	 * to be improved
	 */
	@Override
	public ConcurrentHashMap<String, List<Point>> getAllSpacePoints() {
		// TODO Auto-generated method stub
		ConcurrentHashMap<String,List<Point>> cartesianSpace = new ConcurrentHashMap<String,List<Point>>();
		ArrayList<Point> PointList = new ArrayList<Point>();

		SingletonDatastore.getInstance();
		if(SingletonDatastore.GetCartesianLineSegmentCounter()>=0)
			for (int i=1; i< SingletonDatastore.GetCartesianLineSegmentCounter(); i=i+1) {
				cartesianSpace.put("Line Segment" + i, SingletonDatastore.getCartesianDatastore().get(i));
			}
		else
			cartesianSpace.put("Empty Space, nolding noPoints", PointList);
		return cartesianSpace;
	}
}
