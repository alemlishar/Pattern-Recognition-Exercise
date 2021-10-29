package com.wd.pattern.exercise.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	 * @param point coordinate x , y
	 * @return line points which a new point resides
	 * 
	 */
	@PostMapping("/point")
	public ResponseEntity<String> AddCartesianSpacePoint( Point point) {
		//patternRecognitionServiceImpl.
		int linesNumber = patternRecognitionServiceImpl.CreatePoint(point).size();
 		//SingletonDatastore.getInstance().StorePointToDataStore(point);
		return ResponseEntity.ok("success" + linesNumber);
	}

	/**
	 * @apiNote get all points in every of the lines
	 * @return 	return all datastore line segment
	 * 
	 */
	@GetMapping("/space")
	public ResponseEntity<ConcurrentHashMap<String, List<Point>>> GetCartesianSpacePoints() {
		return ResponseEntity.ok(patternRecognitionServiceImpl.getAllSpacePoints());
	}

	/**
	 * 
	 * @apiNote clear points in space, 
	 * @return success of removal
	 */
	@DeleteMapping("/space")
	public ResponseEntity<String> RemoveCartesianSpacePoints() {

		return patternRecognitionServiceImpl.DeleteCartesianSpacePoints()? ResponseEntity.ok("Successfully deleted") : 
			ResponseEntity.ok("Space point not deleted");
	}

	
	/**  
	 * @param number of Line which holds at least n points
	 * @return list of line segments satisfy the condition
	 */
	@RequestMapping(path="/lines/{n}", method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConcurrentHashMap<String, ArrayList<Point>>> GetCartesianLineSegments( @PathVariable Integer n) {

		ConcurrentHashMap<String, ArrayList<Point>> lineSegments = new ConcurrentHashMap<String, ArrayList<Point>>() ;
		lineSegments = patternRecognitionServiceImpl.getLineSegmentsHavingAtleast(n);
		return ResponseEntity.ok(lineSegments);
	}
}