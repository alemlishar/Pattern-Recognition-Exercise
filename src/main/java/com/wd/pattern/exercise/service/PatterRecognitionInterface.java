package com.wd.pattern.exercise.service;

import java.awt.geom.Point2D;
import java.util.List;

public interface PatterRecognitionInterface {

	public void CreatePoint();
	public boolean IsValidLineSegment();
	public boolean DeleteCartesianSpace();
	public List<Point2D> GetLinesFromSpace();
	public boolean pointExistInLineSegment();

}
