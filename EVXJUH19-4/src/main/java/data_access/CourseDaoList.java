package data_access;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import se.ec.jonatan.fourth_app.Course;
import se.ec.jonatan.fourth_app.Student;

public class CourseDaoList implements CourseDao {
	private static List<Course> courses = new ArrayList<>();
	
	public Course saveCourse(Course course) {
		courses.add(course);
		return course;
	}

	public Course findById(int id) {
		int i=0;
		while(i<courses.size()) {
			i++;
			if(id==courses.get(i-1).getId()) {
				break;
			}
		}
		return courses.get(i-1);
	}

	public List<Course> findByName(String name) {
		List<Course> namesFound = new ArrayList<>();
		for(int i=0; i<courses.size(); i++) {
			if(name.equalsIgnoreCase(courses.get(i).getCourseName())) {
				namesFound.add(courses.get(i));
			}
		}
		return namesFound;
	}

	public List<Course> findByDate(LocalDate date) {
		List<Course> allDatesFound = new ArrayList<>();
		for(int i=0; i<courses.size(); i++) {
			if(courses.get(i).getStartDate()==date) {
				allDatesFound.add(courses.get(i));
			}
		}
		return allDatesFound;
	}

	public List<Course> findAll() {
		List<Course> allFound = new ArrayList<>();
		for(int i=0; i<courses.size(); i++) {
			allFound.add(courses.get(i));
		}
		return allFound;
	}

	public boolean removeCourse(Course course) {
		if(courses.contains(course) ) {
			courses.remove(course);
			return true;
		}
		else {
			return false;
		}
	}
	
	public String CourseToString(Course x) {
		StringBuilder build = new StringBuilder();
		build.append(x.getId() + ", ");
		build.append(x.getCourseName() + ", ");
		build.append(x.getStartDate() + ", ");
		build.append(x.getDuration() + " weeks\n");
		for(int i=0; i<x.getStudents().size(); i++) {
			Student temp = x.getStudents().get(i);
			build.append(StudentDaoList.StudentToString(temp) + ", \n");
		}
		return build.toString();
	}
}