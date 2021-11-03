package com.wd.pattern.exercise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	public ArrayList<Set<String>> getAllSpacePoints();
	public boolean DeleteCartesianSpacePoints();
	/**
	 * read/retrieval
	 */
	public ArrayList<String> getLineSegmentsHavingAtleast(int limit);
	
	/**
	 * Validation
	 */
	public int CheckpointInExistingLine(Point point);
}
