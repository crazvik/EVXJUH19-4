package data_access;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import se.ec.jonatan.fourth_app.Course;

public class CourseDaoList implements CourseDao {
	private static List<Course> courses = new ArrayList<>();
	private static int i;
	
	public Course saveCourse(Course course) {
		i = 0;
		while(i<courses.size()) {
			if(courses.size()>0) {
				if(courses.get(i).getCourseName().equals(course.getCourseName())) {
					return (new Course(0, "Name already taken", LocalDate.parse("0000-00-00"), 0));
				}
				else if(courses.get(i).getId()==(course.getId())) {
					return (new Course(0, "---", LocalDate.parse("0000-00-00"), 0));
				}
			}
			i++;
		}
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
			if(courses.get(i).getStartDate().equals(date)) {
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
	
	public static String CourseToString(Course x) {
		StringBuilder build = new StringBuilder();
		build.append("Id: " + x.getId() + ", ");
		build.append("name: " + x.getCourseName() + ", ");
		build.append("startdate: " + x.getStartDate() + ", ");
		build.append("duration: " + x.getDuration() + " weeks\n");
		return build.toString();
	}
}