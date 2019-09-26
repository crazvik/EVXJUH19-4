package se.ec.jonatan.fourth_app;

import java.time.LocalDate;
import java.util.List;

public class Course {
	private int id;
	private String courseName;
	private LocalDate startDate;
	private int weekDuration;
	private List<Student> students;
	
	public Course(int id, String courseName, LocalDate startDate, int weekDuration, List<Student> students) {
		this.id = id;
		this.courseName = courseName;
		this.startDate = startDate;
		this.weekDuration = weekDuration;
		this.students = students;
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
		students.add(student);
	}
	
	public void unregister(Student student) {
		students.remove(student);
	}
}