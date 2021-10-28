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
import org.springframework.web.bind.annotation.RestController;
import com.wd.pattern.controller.datastore.DatasourceInterfaceImpl;

@RestController
@RequestMapping("cartesian-plane")
public class PatternRecognitionController {

	@Autowired
	DatasourceInterfaceImpl datasourceInterfaceImpl; 
	
	@RequestMapping(path="/point", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> AddCartesianSpacePoint(@Valid @NonNull @PathVariable Point2D point) {
		
		datasourceInterfaceImpl.setCartesianDatasource(point);
		
		return ResponseEntity.ok("success" + point.getX());	
	}

	@RequestMapping(path="/space-points", method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, List<Point2D>>> GetCartesianSpacePoints() {

		
		return null;
	}

	@RequestMapping(path="/space-points", method= RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, List<Point2D>>> RemoveCartesianSpacePoints() {

		
		return null;
	}

	@RequestMapping(path="/lines/{segments}", method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Point2D>> GetCartesianLineSegments( @PathVariable Integer segments) {

		return null;
	}
}