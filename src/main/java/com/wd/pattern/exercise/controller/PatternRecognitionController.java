package com.wd.pattern.exercise.controller;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cartesian-plane")
public class PatternRecognitionController {


	@RequestMapping(path="/point", method= RequestMethod.POST, consumes = {"text/plain", "application/*"})
	public ResponseEntity<String> AddCartesianSpacePoint(@Valid @NonNull @PathVariable Point2D point) {
		return ResponseEntity.ok("success" + point.getX());
	}

	@RequestMapping(path="/space-points", method= RequestMethod.GET, consumes = {"text/plain", "application/*"})
	public ResponseEntity<Map<String, List<Point2D>>> GetCartesianSpacePoints() {

		return null;
	}

	@RequestMapping(path="/space-points", method= RequestMethod.DELETE, consumes = {"text/plain", "application/*"})
	public ResponseEntity<Map<String, List<Point2D>>> RemoveCartesianSpacePoints() {

		return null;
	}

	@RequestMapping(path="/", method= RequestMethod.GET, consumes = {"text/plain", "application/*"})
	public ResponseEntity<List<Point2D>> GetCartesianLineSegments( @Valid @NonNull @PathVariable int numberLimit) {

		return null;
	}
}