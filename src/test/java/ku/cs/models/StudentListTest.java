package ku.cs.models;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    private StudentList studentList;

    @BeforeEach
    void setUp() {
        studentList = new StudentList();
    }

    @Test
    void testAddNewStudentWithNoScore() {
        studentList.addNewStudent("6610450897", "Chawalwit Pornsipak");
        Student student = studentList.findStudentById("6610450897");

        assertEquals("6610450897", student.getId());
        assertEquals("Chawalwit Pornsipak", student.getName());
        assertEquals(0.0, student.getScore());
    }

    @Test
    void testAddNewStudentWithScore() {
        studentList.addNewStudent("6610450897", "Chawalwit Pornsipak", 85.0);
        Student student = studentList.findStudentById("6610450897");

        assertNotNull(student);
        assertEquals("6610450897", student.getId());
        assertEquals("Chawalwit Pornsipak", student.getName());
        assertEquals(85.0, student.getScore());
    }

    @Test
    void testAddDuplicateStudent() {
        studentList.addNewStudent("6610450897", "Chawalwit Pornsipak");
        studentList.addNewStudent("6610450897", "Chawalwit Pornsipak", 90.0);
        ArrayList<Student> students = studentList.getStudents();

        assertEquals(1, students.size());
        assertEquals("Chawalwit Pornsipak", students.get(0).getName());
        assertEquals(0.0, students.get(0).getScore());
    }

    @Test
    void testFindStudentById() {
        studentList.addNewStudent("6610450897", "Chawalwit Pornsipak");
        Student student = studentList.findStudentById("6610450897");

        assertNotNull(student);
        assertEquals("6610450897", student.getId());
        assertEquals("Chawalwit Pornsipak", student.getName());
    }

    @Test
    void testGiveScoreToId() {
        studentList.addNewStudent("6610450897", "Chawalwit Pornsipak", 50.0);
        studentList.giveScoreToId("6610450897", 25.0);
        Student student = studentList.findStudentById("6610450897");

        assertNotNull(student);
        assertEquals(75.0, student.getScore());
    }


    @Test
    void testViewGradeOfId() {
        studentList.addNewStudent("6610450897", "Chawalwit Pornsipak", 70.0);
        String grade = studentList.viewGradeOfId("6610450897");

        assertNotNull(grade);
        assertEquals("F", grade);
    }


    @Test
    void testGetStudents() {
        studentList.addNewStudent("6610450897", "Chawalwit Pornsipak");
        studentList.addNewStudent("6610450xxx", "Chanoot Txxxxxx", 95.0);
        ArrayList<Student> students = studentList.getStudents();

        assertEquals(2, students.size());
    }

}