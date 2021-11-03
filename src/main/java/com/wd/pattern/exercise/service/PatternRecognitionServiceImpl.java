package com.wd.pattern.exercise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
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
		Set<String> pointsInLine = new TreeSet<String>();
		/**
		 * Line must have at least 2 point, to be considered, logger.info("points limit = " + pointsInLine);
		 */
		if(limit <= 0 )
			linesMorethanGivenPoint.add("Invalid Input");

		else if(limit >= 2 ) {
			for(int counter=0; counter < SingletonDatastor1.getCartesianDatastore().size(); counter++) {
				pointsInLine = SingletonDatastor1.getCartesianDatastore().get(counter);
				if(pointsInLine.stream().distinct().count() >= limit) {
					linesMorethanGivenPoint.add("line: " + counter + pointsInLine.toString());
				}
			}
		}
		else linesMorethanGivenPoint.add("a line can't have such number of points");

		return linesMorethanGivenPoint;
	}
	/**
	 * 
	 * 
	 */
	@Override
	public boolean AddpointAsLineSegment(Point point) {
		// TODO Auto-generated method stub
		//CreatePoint(point);
		logger.info("point cordinates" + point.getX() + point.getY());
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
			//logger.info("--the value index---" + SingletonDatastor1.getCartesianDatastore().get(i).get(pointsValue-1));
			CreatePoint(point);
		}
		return SingletonDatastor1.getCartesianDatastore().size() ;
	}

	/**
	 *	@apiNote a new point in to a Cartesian plane
	 *	@param Point with coordinate x, y between 
	 */
	@Override
	public int CreatePoint(Point point) {
		List<String> str = new ArrayList<String>();
		ArrayList<List<String>> points = new ArrayList<List<String>>();
		StringBuilder finalString = new StringBuilder();
		finalString.append("X:" + point.getX() + "," +  "Y:" + point.getY());
		if(SingletonDatastor1.getCartesianDatastore().size() == 0) {
			logger.info("the first two point by any means can make a line, no need to make calculation, simply insert");
			//Optional<List<String>> spacePoints = Optional.ofNullable(SingletonDatastor1.getCartesianDatastore().get(0));
			InsertPointInNewLineSegment(point, 0);
		}
		else if(SingletonDatastor1.getCartesianDatastore().size() >= 0) {
			int valueIndex = computePointToExistInline(point, points);
			logger.info("--- line index ---" + valueIndex);
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

		for(int counter=0; counter < SingletonDatastor1.getCartesianDatastore().size(); counter++) {
			Optional<Set<String>> pointsInLine = Optional.of(SingletonDatastor1.getCartesianDatastore().get(counter));
			/**
			 * if only one point reside , it can make a line insert directly, to the specified line index(counter)
			 */
			if(pointsInLine.isPresent() && pointsInLine.get().size() == 1) {
				logger.info("line number" + counter + "points number in line" + pointsInLine.get().size());
				return counter;
			}
			/**
			 * at least two points exist in the Line
			 */
			else if (pointsInLine.isPresent() && pointsInLine.get().size() > 1) {
				logger.info("line number" + counter + "points number in line" + pointsInLine.get().size());

				boolean valueToadd = false;
				valueToadd = VerifySlopeAndInsert(newPoint,  pointsInLine.get());
				if(valueToadd)
					return counter;
				else {
					/**
					 * insert point in new Line As the first point
					 */
					InsertPointInNewLineSegment(newPoint, counter);
					logger.info("line number" + counter + "size of points in linesegment" + pointsInLine.get().size());
				}
			}

		}
		return SingletonDatastor1.getCartesianDatastore().size();
	}

	/**
	 * @param pointToAdd, new point to be inserted
	 * @param line list of points, to represent two points (point1, point2)
	 * @return  compute if(slope(point1 pointToAdd) == slope(pointToAdd point))  return true; else false; insert else traverse to next line
	 */
	private boolean VerifySlopeAndInsert(Point pointToAdd,Set<String> line ) throws ArithmeticException, PatternSyntaxException
	{ 
		double pointx1,pointy1,pointx2,pointy2, pointNewX,PointNewY;
		boolean computationResult = false;
		List<String> lines = line.stream().collect(Collectors.toList());
		try {
			String[] point1 = lines.get(0).split(",");
			String[] point2 = lines.get(1).split(",");
			String[] x1Val = point1[0].split(":");
			String[] y1Val = point1[1].split(":");
			String[] x2Val = point2[0].split(":");
			String[] y2Val = point2[1].split(":");

			logger.info("value x1 and x2" + x1Val[1] + x2Val[1]);
			logger.info("value y1 and y2" + y1Val[1] + y2Val[1]);

			pointx1 = Double.parseDouble(x1Val[1]);
			pointx2 = Double.parseDouble(x2Val[1]);
			pointy1 = Double.parseDouble(y1Val[1]);
			pointy2 = Double.parseDouble(y2Val[1]);
			pointNewX = Double.parseDouble(pointToAdd.getX());
			PointNewY = Double.parseDouble(pointToAdd.getY());
			computationResult = computePointsSlopeCalculation(pointx1, pointy1, pointx2, pointy2, pointNewX, PointNewY);

		}catch(ArithmeticException e1) {
			throw new ArithmeticException();
		}
		catch (PatternSyntaxException e1) {
			throw new ArithmeticException();
		}
		return computationResult;
	}


	private boolean computePointsSlopeCalculation(double p1x, double p1y,double p2x, double p2y, double pNewx, double pNewy){

		double result1, result2, result3, result4;

		result1 = (p2y - pNewy)/(p2x-pNewx);
		result2 = (p1y - pNewy)/(p1x-pNewx);
		result3 = (pNewy - p1y )/(pNewx - p1x);
		result4  = (pNewy - p2y )/(pNewx - p2x);

		if(	Double.compare(result3, result4) == 0 &&  
				Double.compare(result1, result2) == 0 &&
				Double.compare(result1, result4) == 0 &&
				Double.compare(result2, result3) == 0)

			return true;
		else
			return false;
	}

	/**
	 * Insert the new point (create a new line node or segment) can be the very first point for the space or
	 * in case of the point cant produce the same slope reside in every of the Line segment Space point datastore
	 */
	private void InsertPointInNewLineSegment(Point point, int lineIndex){
		ArrayList<List<String>> points = new ArrayList<List<String>>();
		StringBuilder finalString = new StringBuilder();
		List<String> p1 = new ArrayList<String>();

		finalString.append("X:" + point.getX() + "," +  "Y:" + point.getY());	
		p1.add(finalString.toString());
		points.add(p1);

		SingletonDatastor1.getCartesianDatastore().add(p1.stream().collect(Collectors.toSet()));
		logger.info("line segment " + SingletonDatastor1.getCartesianDatastore().size() + "datas" + SingletonDatastor1.getCartesianDatastore());
	}

	/**
	 * to be improved
	 */
	@Override
	public ArrayList<Set<String>> getAllSpacePoints() {
		// TODO Auto-generated method stub

		return SingletonDatastor1.getInstance().getCartesianDatastore();
	}


}
