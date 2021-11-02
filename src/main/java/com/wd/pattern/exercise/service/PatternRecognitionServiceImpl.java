package com.wd.pattern.exercise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	 * @param  Point with cordinates x and y
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
	public ArrayList<String> getLineSegmentsHavingAtleast(int limit) {
		ArrayList<String> linesMorethanGivenPoint = new ArrayList<String>();
		List<String> pointsInLine = new ArrayList<>();
		/**
		 * Line must have at least 2 point, to be considered, logger.info("points limit = " + pointsInLine);
		 */

		if(limit >= 2 ) {
			for(int counter=0; counter < SingletonDatastor1.getCartesianDatastore().size(); counter++) {
				pointsInLine = SingletonDatastor1.getCartesianDatastore().get(counter);
				if(pointsInLine.size() >= limit) 
					linesMorethanGivenPoint.add("line: " + counter + pointsInLine.toString());
			}
		}
		else if(limit <= 0 )
			linesMorethanGivenPoint.add("Invalid Input");

		else linesMorethanGivenPoint.add("a line can't have such number of points");
		return linesMorethanGivenPoint;
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
			return SingletonDatastor1.getCartesianDatastore().size();
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
	 * to be improved
	 */
	@Override
	public int CreatePoint(Point point) {

		ArrayList<List<String>> points = new ArrayList<List<String>>();
		StringBuilder finalString = new StringBuilder();
		finalString.append("X: " + point.getX() + "," +  "Y: " + point.getY());
		if(SingletonDatastor1.getCartesianDatastore().size() == 0) {
			logger.info("the first two point by any means can make a line, no need to make calculation, simply insert");
			Optional<List<String>> spacePoints = Optional.ofNullable(SingletonDatastor1.getCartesianDatastore().get(0));

			InsertPointInNewLineSegment(point, 0); 
			logger.info("");
		}
		else if(SingletonDatastor1.getCartesianDatastore().size() == 3) {
			int valueIndex = computePointToExistInline(point, points);
			logger.info("line index counter" + valueIndex);
			SingletonDatastor1.getCartesianDatastore().get(valueIndex).add(finalString.toString());
			logger.info("point to be added " + SingletonDatastor1.getCartesianDatastore().get(valueIndex));
		}
		return SingletonDatastor1.getCartesianDatastore().size();
	}
	/**
	 * 
	 * @apiNote compute the line index
	 * @param Point the x,y coordinate to add on the space
	 * @param lineSegments: total spaces 
	 * @return
	 */
	private int computePointToExistInline(Point newPoint, ArrayList<List<String>> lineSegments) {

		Optional<ArrayList<List<String>>> spacePoints = Optional.ofNullable(lineSegments);
		for(int counter=0; counter < SingletonDatastor1.getCartesianDatastore().size(); counter++) {
			Optional<List<String>> pointsInLine = Optional.of(SingletonDatastor1.getCartesianDatastore().get(counter));
			/**
			 * if only one point reside , it can make a line insert directly, to the specified line index(counter)
			 */
			if(!pointsInLine.isPresent() || pointsInLine.get().size() == 1) {
				logger.info("line number" + counter + "size of points in linesegment" + pointsInLine.get().size());
				return counter;
			}
			/**
			 * at least two points exist in the Line
			 */
			else if (pointsInLine.isPresent() && pointsInLine.get().size() >= 2) {
				boolean valueToadd = false;
				if(valueToadd)
					//valueToadd = VerifySlopeAndInsert(newPoint,  pointsInLine.get() );
					return counter;
				else {
					InsertPointInNewLineSegment(newPoint, counter);
				}
			}
			/**
			 * insert point in new Line As the first point
			 */

		}
		return SingletonDatastor1.getCartesianDatastore().size();	
	}

	private boolean VerifySlopeAndInsert(Point pointToAdd,List<String> line ){


		double result1, result2;

		//	result1 = ((p2.getY() - p1.getY())/(p2.getX() - p1.getX());
		//result2 = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());


		return true;
	}
	/**
	 * Insert the new point (create a new line node or segment) can be the very first point or
	 * in case of the line can not reside in every of the Line segment resides on Space point datastore
	 */
	void InsertPointInNewLineSegment(Point point, int lineIndex){
		ArrayList<List<String>> points = new ArrayList<List<String>>();
		StringBuilder finalString = new StringBuilder();
		List<String> p1 = new ArrayList<String>();
		finalString.append("X: " + point.getX() + "," +  "Y: " + point.getY());	
		p1.add(finalString.toString());
		points.add(p1);

		SingletonDatastor1.getCartesianDatastore().add(p1);
		logger.info("line segment " + SingletonDatastor1.getCartesianDatastore().size() + "datas" + SingletonDatastor1.getCartesianDatastore());
	}

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
