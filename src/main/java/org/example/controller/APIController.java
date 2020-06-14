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
    static long count = 0;
    @PostMapping("/learn")
	 public ResponseEntity<?> testSpringBoot( @RequestBody ModelInput input) {
		 	count ++;
			LocalDate date = LocalDate.now();
			DayOfWeek dow = date.getDayOfWeek();
			int day = (dow.getValue()+1) % 7;
			if(day == 0 || day == 1) {
				day = 2;
			}
			int hour = LocalTime.now().getHour();
			int part = 1;
			if ( hour < 12) {
				part = 1;
			} else {
				part = 2;
			}
 		 	List<Learn> lst = service.findByAreaAndDayAndPart(input.getArea(), day , part);
			System.out.println("create list done : hour=" + hour+ " body="+ input.getArea()
					   +"-" + day + "-" + part + " size response="+ lst.size()+ " numCallAPI=" +count);

	        return ResponseEntity.ok().body(lst);
	   }
}
