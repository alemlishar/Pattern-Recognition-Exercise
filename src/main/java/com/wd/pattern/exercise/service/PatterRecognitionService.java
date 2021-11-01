package com.wd.pattern.exercise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.wd.pattern.domain.Point;

public interface PatterRecognitionService {
	/**
	 * creation
	 */
	public int CreatePoint(Point point);
	public boolean AddpointAsLineSegment(Point point);
	public boolean addPointInSinglelineSegment(List<Point> pointList);
	/**
	 * removal
	 */
	public ArrayList<List<String>> getAllSpacePoints();
	public boolean DeleteCartesianSpacePoints();
	/**
	 * read/retrieval
	 */
	public ArrayList<List<String>> getLineSegmentsHavingAtleast(int limit);
	
	public ArrayList<List<String>> getSpecificLineSegment(String LineIdentifier);
	
	/**
	 * Validation
	 */
	public boolean Validation(Object obj);
}
