package se.ec.jonatan.fourth_app;

import java.time.LocalDate;
import java.util.*;

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
			System.out.print("What do you want to do?" + "\nType 1 to add or find students, "
					+ "\nType 2 to create new course, \nType 3 to register students to course or "
					+ "to edit student or course.\nType 4 to quit \nSelection: ");
			String firstAnswer=in.nextLine();
			switch(firstAnswer) {
			case "1":
				System.out.println("\nType 1 to add a student, type 2 to find from Id, "
						+ "\ntype 3 to find from name, type 4 to find from email, "
						+ "\ntype 5 to show all registered students, type 6 to remove selected student.");
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
						System.out.println("Student added: \n	" + StudentDaoList.StudentToString(studentList.findAll().get(studentList.findAll().size()-1))+"\n");
					}
					break;
				case "2":
					read = studentList.findAll().iterator();
					System.out.println();
					while(read.hasNext()) {
						System.out.println("Id: " + read.next().getId());
					}
					id = Integer.parseInt(in.nextLine());
					System.out.println("Student: \n	" + StudentDaoList.StudentToString((studentList.findById(id)))+"\n");
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
						System.out.println("Student: \n	" + StudentDaoList.StudentToString(read.next())+"\n");
					}
					break;
				case "4":
					read = studentList.findAll().iterator();
					while(read.hasNext()) {
						System.out.println("Email: " + read.next().getEmail());
					}
					email = in.nextLine();
					System.out.println("Student: \n	" + StudentDaoList.StudentToString(studentList.findByEmail(email))+"\n");
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
					while(!studentList.findAll().isEmpty()) {
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
					}
					break;
				default:
					System.out.println("Invalid input!\n");	
				}
				break;
			case "2":
				System.out.println("\nType 1 to add a course, type 2 to find from Id, "
						+ "\ntype 3 to find from name, type 4 to find from date, "
						+ "\ntype 5 to show all registered courses, type 6 to remove selected course.");
				answer=in.nextLine();
				switch(answer) {
				case "1":
					System.out.println("\nEnter Id, name, date (format YYYY-MM-DD) and week duration in this order: ");
					int id = Integer.parseInt(in.nextLine());
					String name = in.nextLine();
					LocalDate date = LocalDate.parse(in.nextLine());
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
						System.out.println("Start date: " + read.next().getStartDate());
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
					read = courseList.findAll().iterator();
					System.out.println("Select registered course to remove by typing their id: ");
					while(read.hasNext()) {
						System.out.println("	" + CourseDaoList.CourseToString(read.next()));
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
				System.out.println("\nType 1 to add a student to a course, type 2 to show registered students, "
						+ "\ntype 3 to remove student, type 4 to find from date, "
						+ "\ntype 5 to show all registered courses, type 6 to remove selected course.");
				answer=in.nextLine();
				switch(answer) {
				case "1": 
					Iterator<Course> readCourse = courseList.findAll().iterator();
					while(readCourse.hasNext()) {
						System.out.println("	" + CourseDaoList.CourseToString(readCourse.next()));
					}
					Iterator<Student> readStudent = studentList.findAll().iterator();
					while(readStudent.hasNext()) {
						System.out.println("	" + StudentDaoList.StudentToString(readStudent.next()));
					}
					System.out.print("Type the id of the course: ");
					int courseId = Integer.parseInt(in.nextLine());
					System.out.print("Type the id of the student to add: ");
					int studentId = Integer.parseInt(in.nextLine());
					courseList.findById(courseId).register(studentList.findById(studentId));
					System.out.println("	" + studentList.findById(studentId).getName() + " added to the course "
							+ courseList.findById(courseId).getCourseName());
					break;
				}
			case "4":
				session = false;
				break;
			default:
				System.out.println("Invalid input!\n");
			}
			
				}
		in.close();
		}
	
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