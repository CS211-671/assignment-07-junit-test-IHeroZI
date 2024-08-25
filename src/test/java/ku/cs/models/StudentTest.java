package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    @DisplayName("ทดสอบ changeName(String name)")
    void testChangeName() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.changeName("Chawalwit");
        assertEquals("Chawalwit", s.getName());
        s.changeName("   ");
        assertEquals("Chawalwit", s.getName());
        }

    @Test
    @DisplayName("ทดสอบ addScore(double score)")
    void testAddScore() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(10);
        assertEquals(10, s.getScore());
        s.addScore(-5);
        assertEquals(10, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบ testGrade()")
    void testGrade() {
        Student student = new Student("6xxxxxxxx", "Chawalwit", 55.0);
        assertEquals("F", student.grade());
    }

    @Test
    @DisplayName("ทดสอบ testIsId()")
    void testIsId() {
        Student student = new Student("6610450897", "Chawalwit");
        assertTrue(student.isId("6610450897"));
        assertFalse(student.isId("6610450999"));
    }
}
