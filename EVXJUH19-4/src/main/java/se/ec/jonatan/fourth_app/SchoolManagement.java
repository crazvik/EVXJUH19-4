package se.ec.jonatan.fourth_app;

import java.time.LocalDate;
import java.time.Month;

import data_access.CourseDaoList;
import data_access.StudentDaoList;

public class SchoolManagement {
	public static void main(String[] args) {
		StudentDaoList studentList = new StudentDaoList();
		CourseDaoList courseList = new CourseDaoList();
		studentList.saveStudent(new Student(1, "Name Nameson", "name.nameson", "thisplace"));
		studentList.saveStudent(new Student(2, "Namn Namnson", "namn.namnson", "thatplace"));
		courseList.saveCourse(new Course(1, "Math", LocalDate.of(2019, Month.OCTOBER, 10), 5, studentList.findAll()));
	}
}
