package com.wd.pattern.exercise.service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.wd.pattern.domain.Point;
import com.wd.pattern.domain.Point2DPlane;

public interface PatterRecognitionService {

	public ConcurrentHashMap<String, List<Point>> CreatePoint(Point point);
	public boolean pointExistInLineSegment(Point point);
	public boolean addPointInSinglelineSegment(List<Point> pointList);

	
	public ConcurrentHashMap<String, List<Point>> getAllSpacePoints();
	public boolean DeleteCartesianSpacePoints();
	
	public List<String> getAllLineSegmentIdentifier();
	public List<Point> getSpecificLineSegment(String LineIdentifier);
}
