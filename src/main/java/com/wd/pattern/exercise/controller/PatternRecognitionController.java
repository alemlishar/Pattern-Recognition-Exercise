package com.wd.pattern.exercise.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.wd.pattern.domain.Point;
import com.wd.pattern.exercise.SingletonDatastore;
import com.wd.pattern.exercise.service.PatternRecognitionServiceImpl;


@RestController
public class PatternRecognitionController {

	@Autowired
	private PatternRecognitionServiceImpl patternRecognitionServiceImpl;

	/** 
	 * @apiNote add points in to Cartesian plane
	 * @param point coordinate  x , y(type double)
	 * @return Success message
	 * 
	 */
	@RequestMapping("/point")
	public ResponseEntity<String> AddCartesianSpacePoint(@Valid @RequestBody Point point) {

		/**	
		 *  patternRecognitionServiceImpl.Validation(Point); return true or false  
		 */
		System.out.println("x" + point.getX() + "y" + point.getY());
		boolean val = patternRecognitionServiceImpl.AddpointAsLineSegment(point);
		return val != true? ResponseEntity.ok("success" + SingletonDatastore.GetCartesianLineSegmentCounter()) : 
			ResponseEntity.ok("");
	}

	/**
	 * @apiNote get all points on the cartesian plane
	 * @return 	return all data-store line segment
	 * 
	 */
	@GetMapping("/space")
	public ResponseEntity<ConcurrentHashMap<String, List<Point>>> GetCartesianSpacePoints() {
		return ResponseEntity.ok(patternRecognitionServiceImpl.getAllSpacePoints());
	}

	/**
	 * @apiNote clear points on the Cartesian plane, 
	 * @return ResponseEntity, (true/false) success message
	 */
	@DeleteMapping("/space")
	public ResponseEntity<String> RemoveCartesianSpacePoints() {

		return patternRecognitionServiceImpl.DeleteCartesianSpacePoints()? ResponseEntity.ok("Successfully deleted") : 
			ResponseEntity.ok("Space point not deleted");
	}


	/**  
	 * @param number of points which a Line holds
	 * @return number of Line on the cartesian plane which holds at least n points
	 */
	@RequestMapping(path="/lines/{n}", method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConcurrentHashMap<String, ArrayList<Point>>> GetCartesianLineSegments( @PathVariable Integer n) {

		ConcurrentHashMap<String, ArrayList<Point>> lineSegments = new ConcurrentHashMap<String, ArrayList<Point>>() ;
		lineSegments = patternRecognitionServiceImpl.getLineSegmentsHavingAtleast(n);
		return ResponseEntity.ok(lineSegments);
	}
}
