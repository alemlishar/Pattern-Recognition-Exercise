package com.wd.pattern.exercise.service;

import java.util.ArrayList;
import java.util.List;

import com.wd.pattern.domain.Point;

public interface PatterRecognitionService {
	/**
	 * creation
	 */
	public int CreatePoint(Point point);
	public boolean AddpointAsLineSegment(Point point);
	/**
	 * removal
	 */
	public ArrayList<List<String>> getAllSpacePoints();
	public boolean DeleteCartesianSpacePoints();
	/**
	 * read/retrieval
	 */
	public ArrayList<String> getLineSegmentsHavingAtleast(int limit);
	
	/**
	 * Validation
	 */
	public boolean Validation(Object obj);
	public int CheckpointInExistingLine(Point point);
}
