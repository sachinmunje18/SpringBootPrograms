package com.spring.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class courseServiceImpl implements courseService {

	List<Course> list;

	public courseServiceImpl() {

		list = new ArrayList<>();

		list.add(new Course(101, "java", "core java basics"));
		list.add(new Course(102, "php", "core php basics"));

	}

	@Override
	public List<Course> getCourses() {
		return list;
	}

}
