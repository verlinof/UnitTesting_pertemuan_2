import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void testTambah() {
        //Create obj calculator, assign a dan b
        Calculator calculator = new Calculator(15, 30);

        Assertions.assertEquals(45, calculator.tambah(), "Ini adalah Tes Method Tambah");
    }

    @Test
    void testKurang() {
        //Create obj calculator, assign a dan b
        Calculator calculator = new Calculator(15, 30);

        Assertions.assertEquals(-15, calculator.kurang(), "Ini adalah Tes Method Kurang");
    }

    @Test
    void testKali() {
        //Create obj calculator, assign a dan b
        Calculator calculator = new Calculator(15, 30);

        //Function lainnya
        Assertions.assertNotNull(calculator.kali());

        Assertions.assertEquals(450, calculator.kali(), "Ini adalah Tes Method kali");
    }

    @Test
    void testBagi() {
        //Create obj calculator, assign a dan b
        Calculator calculator = new Calculator(15, 30);

        Assertions.assertEquals(0.5, calculator.bagi(), "Ini adalah Tes Method bagi");

        //Gabungan antara semua assertion
        Assertions.assertAll(
                () -> Assertions.assertEquals(0.5, calculator.bagi()),
                () -> Assertions.assertNotEquals(40, calculator.a),
                () -> Assertions.assertNotNull(calculator.kali())
        );
    }
}
