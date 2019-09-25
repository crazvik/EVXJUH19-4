package se.ec.jonatan.fourth_app;

import data_access.StudentDaoList;

public class SchoolManagement {
	public static void main(String[] args) {
		StudentDaoList studentList = new StudentDaoList();
		studentList.saveStudent(new Student(1, "Name Nameson", "name.nameson", "thisplace"));
		studentList.saveStudent(new Student(2, "Namn Namnson", "namn.namnson", "thatplace"));
		System.out.println(studentList.findAll());
	}
}
