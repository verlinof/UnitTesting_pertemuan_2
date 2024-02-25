import org.example.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentTest {
    @Test
    void testMbkm() {
        Student askar = new Student("Askar", 4, true);
        Student verlino = new Student("Verlino", 7, true);

        Assertions.assertFalse(askar.isDoingMBKM());
        Assertions.assertTrue(verlino.isDoingMBKM());
    }
}
