package com.wd.pattern.exercise.service;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface PatterRecognitionService {

	public ConcurrentHashMap<String, List<Point2D>> CreatePoint(Point2D point);
	public boolean IsValidLineSegment(List<Point2D> pointList);
	public boolean DeleteCartesianSpace();
	public List<Point2D> GetAllLineSegment();
	public boolean pointExistInLineSegment();
	public boolean pointsWithEqualSlope(Point2D p1, Point2D p2);
}
