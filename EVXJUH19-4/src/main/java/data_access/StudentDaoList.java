package data_access;

import java.util.ArrayList;
import java.util.List;

import se.ec.jonatan.fourth_app.Student;

public class StudentDaoList implements StudentDao {
	private static List<Student> students = new ArrayList<>();
	
	public Student saveStudent(Student student) {
		students.add(student);
		return student;
	}

	public Student findByEmail(String email) {
		int i=0;
		while(i<students.size()) {
			if(students.get(i).getEmail().equals(email)) {
				break;
			}
			i++;
		}
		return students.get(i);
	}

	public List<Student> findByName(String name) {
		List<Student> namesFound = new ArrayList<>();
		for(int i=0; i<students.size(); i++) {
			if(name.equalsIgnoreCase(students.get(i).getName())) {
				namesFound.add(students.get(i));
			}
		}
		return namesFound;
	}

	public Student findById(int id) {
		int i=0;
		while(i<students.size()) {
			i++;
			if(id==students.get(i-1).getId()) {
				break;
			}
		}
		return students.get(i-1);
	}

	public List<Student> findAll() {
		List<Student> allFound = new ArrayList<>();
		for(int i=0; i<students.size(); i++) {
			allFound.add(students.get(i));
		}
		return allFound;
	}

	public boolean deleteStudent(Student student) {
		if(students.contains(student) ) {
			students.remove(student);
			return true;
		}
		else {
			return false;
		}
	}
	
	public String StudentToString(Student x) {
		StringBuilder build = new StringBuilder();
		build.append(x.getId() + ", ");
		build.append(x.getName() + ", ");
		build.append(x.getEmail() + ", ");
		build.append(x.getAdress());
		return build.toString();
	}

}
