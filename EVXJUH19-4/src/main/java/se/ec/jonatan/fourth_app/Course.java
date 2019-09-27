package se.ec.jonatan.fourth_app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {
	private int id;
	private String courseName;
	private LocalDate startDate;
	private int weekDuration;
	private List<Student> students;
	
	public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
		this.id = id;
		this.courseName = courseName;
		this.startDate = startDate;
		this.weekDuration = weekDuration;
		students = new ArrayList<>();
	}
	
	public void setId(int n) {
		id = n;
	}
	
	public int getId() {
		return id;
	}
	
	public void setCourseName(String n) {
		courseName = n;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setStartDate(LocalDate d) {
		startDate = d;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setDuration(int w) {
		weekDuration = w;
	}
	
	public int getDuration() {
		return weekDuration;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public void register(Student student) {
		if(students.contains(student)) {
			System.out.println("	Already registered that student\n");
			return;
		}
		students.add(student);
		System.out.println("	" + student.getName() + " added to the course "
							+ getCourseName() + "\n");
	}
	
	public void unregister(Student student) {
		if(!students.contains(student)) {
			System.out.println("Student isn't registered on the course\n");
			return;
		}
		students.remove(student);
		System.out.println("	" + student.getName() + " removed from the course "
				+ getCourseName() + "\n");
	}
}