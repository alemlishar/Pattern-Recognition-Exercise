package com.wd.pattern.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wd.pattern.domain.Point;
import com.wd.pattern.domain.Point2DPlane;

@SpringBootApplication
public class ExerciseApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExerciseApplication.class, args);
		SingletonDatastor1.getInstance();
		
		List<String> str1 = new ArrayList<String>();
		List<String> str2 = new ArrayList<String>();
		List<String> str3 = new ArrayList<String>();
		
		str1.add("a");
		str1.add("b");
		str1.add("c");
		str2.add("a");
		str2.add("b");
		str2.add("c");
		str3.add("a");
		str3.add("b");
		str3.add("c");
		
		SingletonDatastor1.getCartesianDatastore().add(str1);
		SingletonDatastor1.getCartesianDatastore().get(0).add("d");
		SingletonDatastor1.getCartesianDatastore().add(str2);
		SingletonDatastor1.getCartesianDatastore().add(str3);
		
		//cartesianSpace.add(str1);
		//cartesianSpace.get(0).add("hello");
		//cartesianSpace.get(0)


		//System.out.println(SingletonDatastore.getInstance().getCartesianDatastore().get("Line1"));
		//System.out.println(SingletonDatastore.getInstance().getCartesianDatastore().get("Line2"));	
	}

	@Bean
	@Primary
	public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
		ObjectMapper objectMapper = builder.createXmlMapper(false).build();
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		return objectMapper;
	}

	@Bean
	@Primary
	public ConcurrentHashMap<Integer, ArrayList<Point>> initializeDataStore() {

		SingletonDatastore.getInstance();
		ArrayList<Point> points = new ArrayList<Point>();

		//	points.add(new Point((double)4,(double)5));
		//	points.add(new Point((double)5,(double)6));

		//SingletonDatastore.getInstance().getCartesianDatastore().put(SingletonDatastore.getInstance().CartesianLineSegmentCounter(), points);
		//SingletonDatastore.getInstance().getCartesianDatastore().put(SingletonDatastore.getInstance().CartesianLineSegmentCounter(), points);


		return null;
	}
}
