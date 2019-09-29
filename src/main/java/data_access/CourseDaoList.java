package data_access;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import se.ec.jonatan.fourth_app.Course;

public class CourseDaoList implements CourseDao {
	private static List<Course> courses;
	private static int i;

	public CourseDaoList() {
		courses = new ArrayList<>();
	}

	public Course saveCourse(Course course) {
		i = 0;
		while(i<courses.size()) {
			if(courses.size()>0) {
				if(courses.get(i).getCourseName().equals(course.getCourseName())) {
					return (new Course(0, "[Name already taken]", LocalDate.parse("1111-11-11"), 0));
				}
				else if(courses.get(i).getId()==(course.getId())) {
					return (new Course(0, "[Id already taken]", LocalDate.parse("1111-11-11"), 0));
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
				return courses.get(i-1);
			}
		}
		return new Course(0, "[Course not found]", LocalDate.parse("1111-11-11"), 0);
	}

	public List<Course> findByName(String name) {
		List<Course> namesFound = new ArrayList<>();
		for(int i=0; i<courses.size(); i++) {
			if(name.equalsIgnoreCase(courses.get(i).getCourseName())) {
				namesFound.add(courses.get(i));
			}
		}
        if(namesFound.size()==0) {
            namesFound.add((new Course(0, "[No course found]", LocalDate.parse("1111-11-11"), 0)));
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
        if(allDatesFound.size()==0) {
            allDatesFound.add((new Course(0, "[No course found]", LocalDate.parse("1111-11-11"), 0)));
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
		build.append("duration: " + x.getDuration() + " weeks");
		return build.toString();
	}
}