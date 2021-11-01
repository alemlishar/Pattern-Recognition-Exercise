package com.wd.pattern.exercise.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.wd.pattern.domain.Point;
import com.wd.pattern.exercise.SingletonDatastor1;
import com.wd.pattern.exercise.SingletonDatastore;
import com.wd.pattern.exercise.exception.HttpMessageNotReadableException;
import com.wd.pattern.exercise.exception.MethodArgumentNotValidExceptionHandler;
import com.wd.pattern.exercise.service.PatternRecognitionServiceImpl;


@RestController
public class PatternRecognitionController {
	
	final static Logger logger = LoggerFactory.getLogger(PatternRecognitionController.class);

	@Autowired
	private PatternRecognitionServiceImpl patternRecognitionServiceImpl;

	/** 
	 * @apiNote add points in to Cartesian plane
	 * @param point coordinate  x , y(type double)
	 * @return Success message
	 * @throws com.wd.pattern.exercise.exception.HttpMessageNotReadableException 
	 * 
	 */
	@PostMapping("/point")
	public ResponseEntity<String> AddCartesianSpacePoint(@Valid @RequestBody Point point) throws  HttpMessageNotReadableException
																							 {
		/**	
		 *  patternRecognitionServiceImpl.Validation(Point); return true or false  
		 */		
		
		SingletonDatastor1.getInstance();
		int val = patternRecognitionServiceImpl.CreatePoint(point);
		return	 ResponseEntity.ok("success" + val);
	}
	/**
	 * @apiNote get all points on the cartesian plane
	 * @return 	return all data-store line segment
	 * 
	 */
	@GetMapping("/space")
	public ResponseEntity<ArrayList<List<String>>> GetCartesianSpacePoints() {
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
	/*@RequestMapping(path="/lines/{n}", method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConcurrentHashMap<String, ArrayList<Point>>> GetCartesianLineSegments( @PathVariable Integer n) {

		ConcurrentHashMap<String, ArrayList<Point>> lineSegments = new ConcurrentHashMap<String, ArrayList<Point>>() ;
		lineSegments = patternRecognitionServiceImpl.getLineSegmentsHavingAtleast(n);
		return ResponseEntity.ok(lineSegments);
	}*/
}
