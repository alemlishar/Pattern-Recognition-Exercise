package com.wd.pattern.Exercise.Controller.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wd.pattern.domain.Point;

public class PatternRecognitionControllerTest {

	@Autowired
	private RestTemplate restTemplate;

//	@BeforeEach
	void setup() {
	}

//	@Test
	public void StoreValidPointShouldReturnn() {
	/*	//		HttpEntity<String> entity = getStringHttpEntity(meterReadings);
		//	ResponseEntity<String> response = restTemplate.postForEntity("/point", entity, String.class);
		//	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	//	Point p = new Point("4", "5");
		//ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:7777/point", p , String.class);
		String body = response.getBody();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
*/
	}

	//@Test
	public void StoreNullPointShoulReturnError() {
		
		Point p = null;
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:7777/point", p , String.class);
		String body = response.getBody();
		System.out.println(body);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	//@Test
	public void GetEmptySpacePointShouldReturnError() {	
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:7777/point", String.class);
		String body = response.getBody();
		System.out.println(body);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	//@Test
	public void GetNonEmptySpacePointShouldReturnPostiveNumber() {	
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:7777/space", String.class);
		String body = response.getBody();
		System.out.println(body);
	}

	//@Test
	public void deleteEmptySpacePointShouldReturnError() {
		restTemplate.delete("http://localhost:7777/point");

	}

	//@Test
	public void ReadLinesNumberOfPointsGreater() {

	}

	//@Test
	public void ReadLineNumberNumberOfPoints() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:7777/space", String.class);
		String body = response.getBody();
		System.out.println(body);
	
	}
	
	//@Test
	public void ConcurencyCheckStorePointAndRetrive() {
		//assertThat().isEqualTo(HttpStatus.OK);
	}
	
}
