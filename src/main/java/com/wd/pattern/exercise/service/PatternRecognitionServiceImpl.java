package com.wd.pattern.exercise.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.wd.pattern.domain.Point;
import com.wd.pattern.exercise.SingletonDatastor1;

@Service
public class PatternRecognitionServiceImpl implements PatterRecognitionService{



	final static Logger logger = LoggerFactory.getLogger(PatternRecognitionServiceImpl.class);

	/**
	 * @apiNote	Delete all Points in a plane Space
	 * @param Point with cordinates x and y
	 * @return true or false  
	 */
	@Override
	public boolean DeleteCartesianSpacePoints() {
		SingletonDatastor1.getInstance();
		// TODO Auto-generated method stub
		if(SingletonDatastor1.getCartesianDatastore().size()!= 0) {
			SingletonDatastor1.getCartesianDatastore().clear();
			return true;
		}else 
			return false;
	}

	/**
	 * @apiNote	get all LineSegmentsIdentifier
	 * @return get all LineSegmentIdentifier  
	 */
	@Override
	public ArrayList<List<String>> getLineSegmentsHavingAtleast(int limit) {

		ArrayList<List<String>> selectedLineSegments = new ArrayList<List<String>>() ;
		for(int i = 1; i<SingletonDatastor1.GetCartesianLineSegmentCounter(); i++) {
			if(SingletonDatastor1.getCartesianDatastore().get(i).size() > limit)				
				selectedLineSegments.add(SingletonDatastor1.getCartesianDatastore().get(i));
		}
		return selectedLineSegments;
	}

	/**
	 * @apiNote	Create New point in Data storage
	 * @param Point with cordinates x and y
	 * @return datastorage as key value LineSegmentIdentifier, List of Points  
	 */
	@Override
	public ArrayList<List<String>> getSpecificLineSegment(String LineIdentifier) {
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
		/*
		int linesCounter;
		ArrayList<Point> lineSegment = new ArrayList<Point>();
		SingletonDatastor1.getInstance();
		SingletonDatastor1.SetCartesianLineSegmentCounter(SingletonDatastor1.GetCartesianLineSegmentCounter());
		System.out.println("size of datastore" + SingletonDatastor1.getCartesianDatastore().size() + "point" + point.getX() + point.getY());

		if(SingletonDatastor1.GetCartesianLineSegmentCounter()==0)  {
			lineSegment.add(point);
			SingletonDatastor1.storeLineToDataStore(lineSegment);
			SingletonDatastor1.SetCartesianLineSegmentCounter(SingletonDatastor1.GetCartesianLineSegmentCounter()+1);
			System.out.println("first elment of datastore" + SingletonDatastor1.getCartesianDatastore().get(1).get(0));
			return true;
		}
		else if(SingletonDatastor1.GetCartesianLineSegmentCounter() > 0)
			for(int i = 1; i <=SingletonDatastor1.getCartesianDatastore().size(); i++) {
				//get any point from the line segment, atleast one exist get(0)....since it inserted in datastore space	
				lineSegment.add(point);
				SingletonDatastor1.storeLineToDataStore(lineSegment);
				SingletonDatastor1.SetCartesianLineSegmentCounter(SingletonDatastor1.GetCartesianLineSegmentCounter()+1);
				System.out.println("number of line points in a space" + SingletonDatastor1.getCartesianDatastore().toString());

				boolean value = VerifyPointsInline(point, SingletonDatastor1.getCartesianDatastore().get(i).get(0));
				if(value) {
					lineSegment = SingletonDatastor1.getCartesianDatastore().get(i);
					SingletonDatastor1.getCartesianDatastore().get(i).clear();
					lineSegment.add(point);
					SingletonDatastor1.getCartesianDatastore().put(i, lineSegment);
					SingletonDatastor1.SetCartesianLineSegmentCounter(SingletonDatastor1.getCartesianDatastore().size());
					break;
				}
			}*/

		CreatePoint(point);


		return SingletonDatastor1.getCartesianDatastore().size() > 0;
	}

	private  boolean VerifyPointsInline(Point p1, Point p2) {
		return	Double.compare((p2.getY() - p1.getY())/(p2.getX() - p1.getX()),
				(p1.getY() - p2.getY()) / (p1.getX() - p2.getX())) == 0? true:false;
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
	public int CreatePoint(Point point) {
		String newPoint = point.getX() +","+ point.getY(); 
		
		SingletonDatastor1.getInstance();
		ArrayList<List<String>> points = new ArrayList<List<String>>();
		
		List<String> p1 = new ArrayList<String>();
		p1.add(newPoint);
		points.add(p1);
		
		SingletonDatastor1.storeNewLineToDataStore(p1);
		logger.info("----string value to be added--" + newPoint);
		return SingletonDatastor1.getCartesianDatastore().size();
	}
	/**
	 * to be improved
	 */
	@Override
	public ArrayList<List<String>> getAllSpacePoints() {
		// TODO Auto-generated method stub
		ArrayList<List<String>> cartesianSpace = new ArrayList<List<String>>();
		//SingletonDatastor1.getInstance();
		
		//if(SingletonDatastor1.getCartesianDatastore().size()>=0)
		/*for (int i=0; i< SingletonDatastor1.GetCartesianLineSegmentCounter(); i=i+1) {
				cartesianSpace.add( SingletonDatastor1.getCartesianDatastore().get(i));
			}*/

		return SingletonDatastor1.getInstance().getCartesianDatastore();
	}

	@Override
	public boolean Validation(Object obj) {
		// TODO Auto-generated method stub


		return false;
	}
}
