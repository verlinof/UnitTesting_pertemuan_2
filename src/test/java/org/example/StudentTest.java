package org.example;

import org.junit.jupiter.api.*;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentTest {

    private ArrayList<Student> listStudent;

    @BeforeAll
    void setUpClass() {
        listStudent = new ArrayList<Student>();
    }

    @AfterAll
    void cleanUpClass() {
        listStudent.clear();
    }

    @BeforeEach
    void setUpMethod() {
        Student student = new Student("Mayklen", 23);
        listStudent.add(student);
    }

    @AfterEach
    void cleanUpMethod() {
        listStudent.clear();
    }

    @Test
    void testDataCreation() {
        Student student = listStudent.get(0);
        Assertions.assertEquals("Mayklen", student.getName());
        Assertions.assertEquals(23, student.getAge());
    }

    @Test
    void testStudentEnrollment() {
        Student student = listStudent.get(0);
        student.enrollCourse("PPPL");
        student.enrollCourse("PSAIT");
        student.enrollCourse("Metopen");
        String[] expected = {"PPPL", "PSAIT", "Metopen"};

        Assertions.assertEquals(3, student.getEnrolledCourses().size());
        Assertions.assertArrayEquals(expected, student.getEnrolledCourses().toArray());
    }

    @Test
    void testStudentGrade() {
        Student student = listStudent.get(0);

        student.setGrade("PPPL", "A");
        student.setGrade("PSAIT", "B+");
        student.setGrade("Metopen", "C-");

        Assertions.assertAll(
                () -> assertEquals("A", student.getGrade("PPPL")),
                () -> assertEquals("B+", student.getGrade("PSAIT")),
                () -> assertEquals("C-", student.getGrade("Metopen")),
                () -> assertNull(student.getGrade("Math"))
        );
    }
}