package data_access;

import java.util.ArrayList;
import java.util.List;

import se.ec.jonatan.fourth_app.Student;

public class StudentDaoList implements StudentDao {
	private static List<Student> students;
	private static int i;
	
	public StudentDaoList() {
		students = new ArrayList<>();
	}
	
	public Student saveStudent(Student student) {
		i = 0;
		while(i<students.size()) {
			if(students.size()>0) {
				if(students.get(i).getEmail().equals(student.getEmail())) {
					return (new Student(0, "---", "Email already taken", "---"));
				}
				else if(students.get(i).getId()==(student.getId())) {
					return (new Student(0, "---", "---", "---"));
				}
			}
			i++;
		}
		students.add(student);
		return student;
	}

	public Student findByEmail(String email) {
		int i=0;
		while(i<students.size()) {
			if(students.get(i).getEmail().equals(email)) {
				return students.get(i);
			}
		i++;
		}
		return (new Student(0, "No student found", "---", "---"));
	}

	public List<Student> findByName(String name) {
		List<Student> namesFound = new ArrayList<>();
		for(int i=0; i<students.size(); i++) {
			if(name.equalsIgnoreCase(students.get(i).getName())) {
				namesFound.add(students.get(i));
				break;
			}
		}
		if(namesFound.size()==0) {
			namesFound.add((new Student(0, "No student found", "---", "---")));
		}
		return namesFound;
	}

	public Student findById(int id) {
		int i=0;
		while(i<students.size()) {
			i++;
			if(id==students.get(i-1).getId()) {
				return students.get(i-1);
			}
		}
		return (new Student(0, "No student found", "---", "---"));
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
	
	public static String StudentToString(Student x) {
		StringBuilder build = new StringBuilder();
		build.append("Id: " + x.getId() + ", ");
		build.append("name: " +x.getName() + ", ");
		build.append("email: " +x.getEmail() + ", ");
		build.append("adress: " + x.getAdress());
		return build.toString();
	}
}