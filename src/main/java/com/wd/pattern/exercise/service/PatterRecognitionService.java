package com.wd.pattern.exercise.service;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wd.pattern.domain.Point;
import com.wd.pattern.exercise.SingletonDatastore;

public interface PatterRecognitionService {

	public ConcurrentHashMap<String, List<Point2D>> CreatePoint(Point2D point);
	public boolean pointExistInLineSegment(Point point);
	public boolean addPointInSinglelineSegment(List<Point> pointList);

	public boolean DeleteCartesianSpacePoints();
	
	public List<String> getAllLineSegmentIdentifier();
	
	public List<Point> getSpecificLineSegment(String LineIdentifier);
}
