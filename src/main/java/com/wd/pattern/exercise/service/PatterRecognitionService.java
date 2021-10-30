package com.wd.pattern.exercise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.wd.pattern.domain.Point;

public interface PatterRecognitionService {
	/**
	 * creation
	 */
	public ConcurrentHashMap<Integer, ArrayList<Point>> CreatePoint(Point point);
	public boolean AddpointAsLineSegment(Point point);
	public boolean addPointInSinglelineSegment(List<Point> pointList);
	/**
	 * removal
	 */
	public ConcurrentHashMap<String, List<Point>> getAllSpacePoints();
	public boolean DeleteCartesianSpacePoints();
	/**
	 * read/retrieval
	 */
	public ConcurrentHashMap<String, ArrayList<Point>> getLineSegmentsHavingAtleast(int limit);
	
	public List<Point> getSpecificLineSegment(String LineIdentifier);
	
	/**
	 * Validation
	 */
	public boolean Validation(Object obj);
}
