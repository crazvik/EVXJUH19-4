package se.ec.jonatan.fourth_app;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import javax.management.RuntimeErrorException;

import data_access.CourseDaoList;
import data_access.StudentDaoList;

public class SchoolManagement {
	static StudentDaoList studentList = new StudentDaoList();
	static CourseDaoList courseList = new CourseDaoList();
	static String answer = "";
	static boolean session = true;
	static Iterator<Student> read;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while(session) {
			System.out.println("What do you want to do?" + " Type 1 to add a student, type 2 to quit");
			answer=in.nextLine();
			switch(answer) {
			case "1":
				int id = Integer.parseInt(in.nextLine());
				String name = in.nextLine();
				String email = in.nextLine();
				String adress = in.nextLine();
				registerNewStudent(id, name, email, adress);
				read = studentList.findAll().iterator();
				if(read.hasNext()) {
					System.out.println("Student added: " + StudentDaoList.StudentToString(studentList.findAll().get(studentList.findAll().size()-1))+"\n");
				}
				break;
			case "2":
				read = studentList.findAll().iterator();
				System.out.println();
				while(read.hasNext()) {
					System.out.println("Id: " + read.next().getId());
				}
				id = Integer.parseInt(in.nextLine());
				System.out.println("\nStudent: " + StudentDaoList.StudentToString((studentList.findById(id))));
				break;
			case "3":
				read = studentList.findAll().iterator();
				System.out.println();
				while(read.hasNext()) {
					System.out.println("Name: " + read.next().getName());
				}
				name = in.nextLine();
				read = studentList.findByName(name).iterator();
				while(read.hasNext()) {
					System.out.println("\nStudent: " + StudentDaoList.StudentToString(read.next()));
				}
				break;
			case "4":
				read = studentList.findAll().iterator();
				System.out.println();
				while(read.hasNext()) {
					System.out.println("Email: " + read.next().getEmail());
				}
				email = in.nextLine();
				System.out.println("\nStudent: " + StudentDaoList.StudentToString(studentList.findByEmail(email)));
				break;
			case "5":
				read = studentList.findAll().iterator();
				System.out.println("Registered students: ");
				while(read.hasNext()) {
					System.out.println("	" + StudentDaoList.StudentToString(read.next()));
				}
				System.out.println();
				break;
			}
		}

				
		/*if(studentList.deleteStudent(studentList.findById(4))==true) {
			System.out.println("\nStudent removed\n");
		}
		else {
			System.out.println("\nNo student found\n");
		}
		
		*/
		
		courseList.saveCourse(new Course(53773, "Math", LocalDate.of(2019, Month.OCTOBER, 10), 5, studentList.findAll()));
		courseList.saveCourse(new Course(46275, "Programming", LocalDate.of(2019, Month.OCTOBER, 10), 6, studentList.findAll()));
		System.out.println("\n"+courseList.CourseToString(courseList.findById(46275)));
		studentList.findAll().get(0).setId(24);
		System.out.println(courseList.CourseToString(courseList.findById(53773)));
		courseList.findAll().get(0).getCourseName();
	}
	
	public static Student registerNewStudent(int id, String name, String email, String adress) {
		Student student = new Student(id, name, email, adress);
		studentList.saveStudent(student);
		return student;
	}
}
