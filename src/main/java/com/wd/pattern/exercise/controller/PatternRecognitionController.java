package com.wd.pattern.exercise.controller;
import java.awt.geom.Point2D;
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
@RequestMapping("/cartesian-plane")
public class PatternRecognitionController {

	@Autowired
	private PatternRecognitionServiceImpl patternRecognitionServiceImpl;


	/** 
	 * @param point coordinate x , y
	 * @return line points which a new point resides
	 * 
	 */
	@PostMapping("/store/space-point")
	public ResponseEntity<String> AddCartesianSpacePoint( Point point) {
		SingletonDatastore.getInstance().StorePointToDataStore(point);
		return ResponseEntity.ok("success" + SingletonDatastore.getInstance().getCartesianDatastore().size());
	}

	/**
	 * @apiNote get all points in every of the lines
	 * @return 	return all datastore line segment
	 * 
	 */
	@GetMapping("/read/space-point")
	public ResponseEntity<ConcurrentHashMap<String, List<Point>>> GetCartesianSpacePoints() {
		ConcurrentHashMap<String,List<Point>> cartesianSpace = new ConcurrentHashMap<String,List<Point>>();
		ArrayList PointList = new ArrayList<Point>();
		cartesianSpace.put("Empty Space, nolding noPoints", PointList);
		System.out.println(SingletonDatastore.getInstance().getCartesianDatastore().size());
		
		return  patternRecognitionServiceImpl.getAllSpacePoints().size() > 0 ?
				ResponseEntity.ok(SingletonDatastore.getInstance().getCartesianDatastore()) : ResponseEntity.ok(cartesianSpace);
	}

	/**
	 * 
	 * @apiNote clear points in space, 
	 * @return success of removal
	 */
	@DeleteMapping("/remove/space-point")
	public ResponseEntity<String> RemoveCartesianSpacePoints() {

		return patternRecognitionServiceImpl.DeleteCartesianSpacePoints()? ResponseEntity.ok("Successfully deleted") : ResponseEntity.ok("Successfully deleted");
	}

	/**  
	 * @param number of Line which holds maximum n points
	 * @return list of line segments satisfy the condition
	 */
	@RequestMapping(path="read/lines/{n}", method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Point2D>> GetCartesianLineSegments( @PathVariable Integer n) {

		return null;
	}
}