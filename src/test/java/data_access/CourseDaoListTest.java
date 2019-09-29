package data_access;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.ec.jonatan.fourth_app.Course;

import java.time.LocalDate;

class CourseDaoListTest {
    private static CourseDaoList testCourse = new CourseDaoList();
    private Course course1 = new Course(1, "Course1", LocalDate.parse("2019-01-01"), 10);
    private Course course2 = new Course(2, "Course2", LocalDate.parse("2019-05-15"), 10);
    private Course course3 = new Course(500, "Course3", LocalDate.parse("2019-07-25"), 10);
    private Course course4 = new Course(100, "Course4", LocalDate.parse("2019-12-10"), 10);
    private Course course5 = new Course(20, "Course5", LocalDate.parse("2019-03-30"), 10);

    @BeforeEach
    void setUp() {
        testCourse = new CourseDaoList();
    }

    @Test
    void testSaveCourse() {
        testCourse.saveCourse(course1);
        Assertions.assertNotNull(testCourse);
        testCourse.saveCourse(course2);
    }

    @Test
    void testFindById() {
        testCourse.saveCourse(course3);
        Assertions.assertEquals(CourseDaoList.CourseToString(testCourse.findById(500)), CourseDaoList.CourseToString(testCourse.findAll().get(0)));
    }

    @Test
    void testFindByName() {
        testCourse.saveCourse(course2);
        testCourse.saveCourse(course4);
        testCourse.saveCourse(course5);
        Assertions.assertEquals(testCourse.findByName("Course2").get(0), testCourse.findAll().get(0));
        Assertions.assertNotEquals(testCourse.findByName("Course4"), testCourse.findAll().get(0));
    }

    @Test
    void testFindByDate() {
        testCourse.saveCourse(course1);
        testCourse.saveCourse(course3);
        testCourse.saveCourse(course4);
        Assertions.assertEquals(testCourse.findByDate(LocalDate.parse("2019-12-10")).get(0), testCourse.findAll().get(2));
    }

    @Test
    void testFindAll() {
        testCourse.saveCourse(course1);
        testCourse.saveCourse(course2);
        testCourse.saveCourse(course3);
        testCourse.saveCourse(course4);
        testCourse.saveCourse(course5);
        Iterable<Course> courseIterator1 = testCourse.findAll();
        CourseDaoList findSomeCourses = new CourseDaoList();
        findSomeCourses.saveCourse(course1);
        findSomeCourses.saveCourse(course2);
        findSomeCourses.saveCourse(course3);
        findSomeCourses.saveCourse(course4);
        findSomeCourses.saveCourse(course5);
        Iterable<Course> courseIterator2 = findSomeCourses.findAll();
        Assertions.assertIterableEquals(courseIterator1, courseIterator2);
    }

    @Test
    void testRemoveCourse() {
    	testCourse.saveCourse(course2);
    	testCourse.saveCourse(course4);
    	Assertions.assertTrue(testCourse.removeCourse(course2));
    	Assertions.assertFalse(testCourse.removeCourse(course1));
    }

    @Test
    void testCourseToString() {
    	Assertions.assertEquals("Id: 500, name: Course3, startdate: 2019-07-25, duration: 10 weeks", CourseDaoList.CourseToString(testCourse.saveCourse(course3)));
    	Assertions.assertNotEquals("Id: 100, name: Course4, startdate: 2019-12-10, duration: 10 weeks", CourseDaoList.CourseToString(testCourse.saveCourse(course3)));
    }
}