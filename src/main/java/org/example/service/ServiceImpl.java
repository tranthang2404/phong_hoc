package org.example.service;
import java.util.List;

import org.example.entity.Learn;
import org.example.repo.LearnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServiceImpl implements ServiceLearn {
	@Autowired
	private LearnRepo learnRepo;



	@Override
	public List<Learn> findByAreaAndDayAndPart(int area, int day, int part) {

		List<Learn> lst = learnRepo.findByPartOfUNAndDayOfWeekAndPartOfDay(area,day,part);
		return lst;
	}
}
