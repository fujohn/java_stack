package com.johnfu.firstproject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello") // class level annotation, all routes below will become /hello/___
public class HomeController {
	@RequestMapping("") // with class level annotation, dont need slash for index
	public String index(@RequestParam(value="q", required=false) String searchQuery) {
		if (searchQuery == null) {
			return "Hello John";
		} else {
			return "You searched for: " + searchQuery;
		}
	}
	
	@RequestMapping("/world")
	public String world() {
		return "Class level annotations are cool too!";
	}
	
	@RequestMapping("/m/{track}/{module}/{lesson}")
	public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
    }
}
