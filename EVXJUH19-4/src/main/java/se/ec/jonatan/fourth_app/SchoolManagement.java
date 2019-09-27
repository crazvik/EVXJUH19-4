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
			System.out.println("What do you want to do?" + "\nType 1 to add or find students, "
					+ "\nType 2 to add student(s) to course, \nType 3 to quit.");
			String firstAnswer=in.nextLine();
			switch(firstAnswer) {
			case "1":
				System.out.println("\nType 1 to add a student, type 2 to find from Id, "
						+ "\ntype 3 to find from name, type 4 to find from email, "
						+ "\ntype 5 to show all registered students.");
				answer=in.nextLine();
				switch(answer) {
				case "1":
					System.out.println("\nEnter Id, name, email and adress in this order: ");
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
					System.out.println("Student: " + StudentDaoList.StudentToString((studentList.findById(id)))+"\n");
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
						System.out.println("Student: " + StudentDaoList.StudentToString(read.next())+"\n");
					}
					break;
				case "4":
					read = studentList.findAll().iterator();
					while(read.hasNext()) {
						System.out.println("Email: " + read.next().getEmail());
					}
					email = in.nextLine();
					System.out.println("Student: " + StudentDaoList.StudentToString(studentList.findByEmail(email))+"\n");
					break;
				case "5":
					read = studentList.findAll().iterator();
					System.out.println("Registered students: ");
					while(read.hasNext()) {
						System.out.println("	" + StudentDaoList.StudentToString(read.next()));
					}
					System.out.println();
					break;
				case "6":
					read = studentList.findAll().iterator();
					System.out.println("Select registered student to remove by typing their id: ");
					while(read.hasNext()) {
						System.out.println("	" + StudentDaoList.StudentToString(read.next()));
					}
					id = Integer.parseInt(in.nextLine());
					if(studentList.deleteStudent(studentList.findById(id))==true) {
						System.out.println("\nStudent removed\n");
					}
					else {
						System.out.println("\nNo student found\n");
					}
					break;
				default:
					System.out.println("Invalid input!\n");	
				}
				break;
			case "2":
				System.out.println("\nType 1 to add a student, type 2 to find from Id, "
						+ "\ntype 3 to find from name, type 4 to find from email, "
						+ "\ntype 5 to show all registered students.");
				answer=in.nextLine();
				switch(answer) {
				case "1":
					System.out.println("\nEnter Id, name, date (format YYYY-MM-DD) and week duration in this order: ");
					int id = Integer.parseInt(in.nextLine());
					String name = in.nextLine();
					LocalDate date = LocalDate.of(Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()));
					int duration = Integer.parseInt(in.nextLine());
					registerNewCourse(id, name, date, duration);
					Iterator<Course> read = courseList.findAll().iterator();
					if(read.hasNext()) {
						System.out.println("Course added: " + CourseDaoList.CourseToString(courseList.findAll().get(courseList.findAll().size()-1))+"\n");
					}
					break;
				case "2":
					read = courseList.findAll().iterator();
					System.out.println();
					while(read.hasNext()) {
						System.out.println("Id: " + read.next().getId());
					}
					id = Integer.parseInt(in.nextLine());
					System.out.println("Course: " + CourseDaoList.CourseToString((courseList.findById(id)))+"\n");
					break;
				case "3":
					read = courseList.findAll().iterator();
					System.out.println();
					while(read.hasNext()) {
						System.out.println("Name: " + read.next().getCourseName());
					}
					name = in.nextLine();
					read = courseList.findByName(name).iterator();
					while(read.hasNext()) {
						System.out.println("Student: " + CourseDaoList.CourseToString(read.next())+"\n");
					}
					break;
				case "4":
					read = courseList.findAll().iterator();
					while(read.hasNext()) {
						System.out.println("Email: " + read.next().getStartDate());
					}
					date = LocalDate.parse(in.nextLine());
					read = courseList.findByDate(date).iterator();
					while(read.hasNext()) {
						System.out.println("Course: " + CourseDaoList.CourseToString(read.next())+"\n");
					}
					break;
				case "5":
					read = courseList.findAll().iterator();
					System.out.println("Registered courses: ");
					while(read.hasNext()) {
						System.out.println("	" + CourseDaoList.CourseToString(read.next()));
					}
					System.out.println();
					break;
				case "6":
					read = studentList.findAll().iterator();
					System.out.println("Select registered student to remove by typing their id: ");
					while(read.hasNext()) {
						System.out.println("	" + StudentDaoList.StudentToString(read.next()));
					}
					id = Integer.parseInt(in.nextLine());
					if(studentList.deleteStudent(studentList.findById(id))==true) {
						System.out.println("\nStudent removed\n");
					}
					else {
						System.out.println("\nNo student found\n");
					}
					break;
				}
				break;
			case "3":
				session = false;
				break;
			default:
				System.out.println("Invalid input!\n");
			}
			
				}
		in.close();
		}
	/*			
	courseList.saveCourse(new Course(53773, "Math", LocalDate.of(2019, Month.OCTOBER, 10), 5, studentList.findAll()));
	courseList.saveCourse(new Course(46275, "Programming", LocalDate.of(2019, Month.OCTOBER, 10), 6, studentList.findAll()));
	System.out.println("\n"+courseList.CourseToString(courseList.findById(46275)));
	studentList.findAll().get(0).setId(24);
	System.out.println(courseList.CourseToString(courseList.findById(53773)));
	courseList.findAll().get(0).getCourseName();
*/
	
	public static Student registerNewStudent(int id, String name, String email, String adress) {
		Student student = new Student(id, name, email, adress);
		studentList.saveStudent(student);
		return student;
	}
	
	public static Course registerNewCourse(int id, String name, LocalDate date, int week) {
		Course course = new Course(id, name, date, week);
		courseList.saveCourse(course);
		return course;
	}
}