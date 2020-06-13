package org.example.entity;


import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "learn")
@Getter
@Setter
public class Learn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial",name ="learn_id")

	private Long learnID;

	 @Column(name="class_id")
	   private int classID;
	 
	 @Column(name="name_class")
	   private String nameClass;
	 
	 @Column(name="name_lesson")
	   private String nameLesson;
	 
	 @Column(name="day_of_week")
	   private int dayOfWeek;
	 
	 @Column(name="start_learn")
	   private int startLearn;
	 
	 @Column(name="end_learn")
	   private int endLearn;
	 
	 @Column(name="part_of_day")
	   private int partOfDay;
	 @Column(name="part_of_un")
	   private int partOfUN;
}
