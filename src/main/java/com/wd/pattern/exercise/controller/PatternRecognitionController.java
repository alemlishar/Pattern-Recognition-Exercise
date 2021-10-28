package com.wd.pattern.exercise.controller;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wd.pattern.domain.Point;
import com.wd.pattern.exercise.SingletonDatastore;
import com.wd.pattern.exercise.service.PatternRecognitionServiceImpl;

@RestController
@RequestMapping("/cartesian-plane")
public class PatternRecognitionController {

	@Autowired
	PatternRecognitionServiceImpl patternRecognitionServiceImpl;

	
	
	@RequestMapping(path="/point", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, 
								 																			produces = MediaType.APPLICATION_JSON_VALUE)
	/**
	 * 
	 * @param point coordinate x , y
	 * @return line points which a new point resides
	 * 
	 **/
	public ResponseEntity<String> AddCartesianSpacePoint(@Valid @NonNull @RequestParam Point point) {
		patternRecognitionServiceImpl.CreatePoint(point);
		return ResponseEntity.ok("success" + point.getX() + point.getY());
	}

	/**
	 * @apiNote get all points in every of the lines
	 * @return 	return all datastore line segment
	 * 
	 */
	@RequestMapping(path="/space-points", method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, List<Point2D>>> GetCartesianSpacePoints() {
		
		return ResponseEntity.ok(SingletonDatastore.getInstance().getCartesianDatastore()); 
	}

	/**
	 * 
	 * @apiNote clear points in space, 
	 * @return success of removal
	 */
	@RequestMapping(path="/space-points", method= RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> RemoveCartesianSpacePoints() {
		
	 return patternRecognitionServiceImpl.DeleteCartesianSpacePoints()? ResponseEntity.ok("Successfully deleted") : ResponseEntity.ok("Successfully deleted");
	
	}

	/**  
	 * @param number of Line which holds maximum n points
	 * @return list of line segments satisfy the condition
	 */
	@RequestMapping(path="/lines-segments/{number}", method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Point2D>> GetCartesianLineSegments( @PathVariable Integer segments) {

		return null;
	}
}