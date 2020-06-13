package org.example.repo;

import java.util.List;

import org.example.entity.Learn;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LearnRepo extends JpaRepository<Learn, Integer>{
	List<Learn> findByPartOfUNAndDayOfWeekAndPartOfDay(int area,int day,int part);
}
