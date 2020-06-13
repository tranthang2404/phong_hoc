package org.example.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.example.entity.Learn;
import org.example.model.ModelInput;
import org.example.service.ServiceLearn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.PostMapping;
@RestController

public class APIController {
	@Autowired
    private ServiceLearn service;

    @PostMapping("/learn")
	 public ResponseEntity<?> testSpringBoot( @RequestBody ModelInput input) {
			LocalDate date = LocalDate.now();
			DayOfWeek dow = date.getDayOfWeek();
			int hour = LocalTime.now().getHour();
			int part = 1;
			if ( hour < 12) {
				part = 1;
			} else {
				part = 2;
			}
 		 	List<Learn> lst = service.findByAreaAndDayAndPart(input.getArea(),(dow.getValue()+1) % 7 ,part);
			System.out.println("create list done : partArea = " + input.getArea());

	        return ResponseEntity.ok().body(lst);
	   }
}
