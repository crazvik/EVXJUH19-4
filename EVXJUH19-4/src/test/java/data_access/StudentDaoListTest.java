package data_access;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.ec.jonatan.fourth_app.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentDaoListTest {
    private static StudentDaoList testStudents;
    private Student student1 = new Student(1, "Student1", "Student.1", "someplace");
    private Student student2 = new Student(2, "Student2", "Student.2", "there");
    private Student student3 = new Student(3, "Student3", "Student.3", "over here");
    private Student student4 = new Student(4, "Student4", "Student.4", "somewhere");
    private Student student5 = new Student(5, "Student5", "Student.5", "cabbage patch");

    @BeforeEach
    void setUp() {
        testStudents = new StudentDaoList();
    }

    @Test
    void testSaveStudent() {
        testStudents.saveStudent(student1);
        Assertions.assertNotNull(testStudents);
        testStudents.saveStudent(student2);
        Assertions.assertEquals(testStudents.findAll().get(0), student1);
    }

    @Test
    void testFindByEmail() {
        testStudents.saveStudent(student3);
        testStudents.saveStudent(student1);
        Assertions.assertEquals(StudentDaoList.StudentToString(testStudents.findByEmail("Student.1")), StudentDaoList.StudentToString(testStudents.findAll().get(1)));
        Assertions.assertNotEquals(StudentDaoList.StudentToString(testStudents.findByEmail("Student.3")), StudentDaoList.StudentToString(testStudents.findAll().get(1)));
    }

    @Test
    void testFindByName() {
        testStudents.saveStudent(student4);
        testStudents.saveStudent(student5);
        Assertions.assertEquals(testStudents.findByName("Student5").get(0), testStudents.findAll().get(1));
        Assertions.assertNotEquals(testStudents.findByName("Student5").get(0), testStudents.findAll().get(0));
    }

    @Test
    void testFindById() {
        testStudents.saveStudent(student4);
        testStudents.saveStudent(student2);
        Assertions.assertEquals(testStudents.findById(4), testStudents.findAll().get(0));
        Assertions.assertNotEquals(testStudents.findById(2), testStudents.findAll().get(0));
    }

    @Test
    void testFindAll() {
        testStudents.saveStudent(student1);
        testStudents.saveStudent(student2);
        testStudents.saveStudent(student3);
        testStudents.saveStudent(student4);
        testStudents.saveStudent(student5);
        Iterable<Student> studentIterator1 = testStudents.findAll();
        StudentDaoList findSomeStudents = new StudentDaoList();
        findSomeStudents.saveStudent(student1);
        findSomeStudents.saveStudent(student2);
        findSomeStudents.saveStudent(student3);
        findSomeStudents.saveStudent(student4);
        findSomeStudents.saveStudent(student5);
        Iterable<Student> studentIterator2 = findSomeStudents.findAll();
        assertIterableEquals(studentIterator1, studentIterator2);
    }

    @Test
    void testDeleteStudent() {
        testStudents.saveStudent(student3);
        testStudents.saveStudent(student5);
        Assertions.assertTrue(testStudents.deleteStudent(student3));
        Assertions.assertFalse(testStudents.deleteStudent(student1));
    }

    @Test
    void testStudentToString() {
        Assertions.assertEquals("Id: 1, name: Student1, email: Student.1, adress: someplace",
                                StudentDaoList.StudentToString(testStudents.saveStudent(student1)));
        Assertions.assertNotEquals("Id: 5, name: Student5, email: Student.5, adress: cabbage patch",
                                StudentDaoList.StudentToString(testStudents.saveStudent(student3)));
    }
}