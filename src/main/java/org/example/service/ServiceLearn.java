package org.example.service;
import java.util.List;

import org.example.entity.Learn;
import org.springframework.stereotype.Service;



@Service
public interface ServiceLearn {
	List<Learn> findByAreaAndDayAndPart(int area,int day,int part);
}
