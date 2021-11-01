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

		CreatePoint(point);

		return SingletonDatastor1.getCartesianDatastore().size() > 0;
	}

	@Override
	public int CheckpointInExistingLine(Point point) {
		if(SingletonDatastor1.getCartesianDatastore().size()==0)  
		{
			logger.info("--the first point---" );
			CreatePoint(point);
			return SingletonDatastor1.getCartesianDatastore().size() ;
		}
		for(int i = 0; i <=SingletonDatastor1.getCartesianDatastore().size(); i++) 
		{
			int pointsValue = SingletonDatastor1.getCartesianDatastore().get(i).size();
			logger.info("--the value index---" + SingletonDatastor1.getCartesianDatastore().get(i).get(pointsValue-1));
			CreatePoint(point);
		}
		return SingletonDatastor1.getCartesianDatastore().size() ;
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

		logger.info("the first two point by any means can make a line, no need to make calculation, simply insert"  );
		
		if(SingletonDatastor1.getCartesianDatastore().size() == 1 && SingletonDatastor1.getCartesianDatastore().get(1).size() <2 ) {
			List<String> p1 = new ArrayList<String>();
			p1.add(newPoint);
			points.add(p1);
			SingletonDatastor1.storeNewLineToDataStore(p1);
		}
		/**
		 * calculate if true, insert on the index 
		 * else create new node of a line
		 * boolean slope = VerifyPointsInline(point);  if true  
		 */
		
		return SingletonDatastor1.getCartesianDatastore().size();
	}

	/*private boolean VerifyPointInline(Point p1, Point p2, List<String> lineSegments) {
		
		logger.info("----string value to be added--" + p1);
		logger.info("total line segments" + SingletonDatastor1.getCartesianDatastore().size() + "points in space " );

		for (int i=1; i<SingletonDatastor1.getCartesianDatastore().size();i++) {
			
			System.out.println("points in line " + SingletonDatastor1.getCartesianDatastore().get(i).get(0));
		
		}
		/** use either of this formula
		 *  ax + by = c
		 *  ax - by = c
		 
		return	Double.compare((p2.getY() - p1.getY())/(p2.getX() - p1.getX()),
				(p1.getY() - p2.getY()) / (p1.getX() - p2.getX())) == 0? true:false;
	}*/

	/**
	 * to be improved
	 */
	@Override
	public ArrayList<List<String>> getAllSpacePoints() {
		// TODO Auto-generated method stub
		ArrayList<List<String>> cartesianSpace = new ArrayList<List<String>>();

		return SingletonDatastor1.getInstance().getCartesianDatastore();
	}

	@Override
	public boolean Validation(Object obj) {
		// TODO Auto-generated method stub

		return false;
	}
}
