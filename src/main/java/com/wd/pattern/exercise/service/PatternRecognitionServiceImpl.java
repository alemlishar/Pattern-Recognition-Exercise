package com.wd.pattern.exercise.service;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.wd.pattern.exercise.SingletonDatastore;

@Service
public class PatternRecognitionServiceImpl implements PatterRecognitionService{


	@Override
	public ConcurrentHashMap<String, List<Point2D>> CreatePoint(Point2D point) {
		ConcurrentHashMap<String, List<Point2D>> dataStore = SingletonDatastore.getInstance().getCartesianDatastore();
		dataStore.put("lineSegment" + SingletonDatastore.getInstance().CartesianLineSegmentCounter() + 1,List.of(point));
		return dataStore;}

	@Override
	public boolean IsValidLineSegment(List<Point2D> points) {

		return false;
	}

	@Override
	public boolean DeleteCartesianSpace() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pointExistInLineSegment() {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public List<Point2D> GetAllLineSegment() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean pointsWithEqualSlope(Point2D p1, Point2D p2) {
		// TODO Auto-generated method stub
		return false;
	}

}
