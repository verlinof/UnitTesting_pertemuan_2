import org.example.Calculator;
import org.junit.jupiter.api.*;

//Buat biar tiap test case memiliki lifecycle di class bukan di function
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//Biar bisa ngatur order dari testcase
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {
    private double result = 0;

    @BeforeAll
    void setUpClass() {
        System.out.println("before all/setup class");
    }

    @BeforeEach
    void setupMethod() {
        System.out.println("Setup Method/before each");
    }

    @AfterEach
    void cleanMethod() {
        System.out.println("clean method/after each");
    }

    @AfterAll
    void cleanClass() {
        System.out.println("clean class/after all");
    }

    @Test
    @Order(1)
    void testTambah() {
        //Create obj calculator, assign a dan b
        Calculator calculator = new Calculator(10, 7);
        result = calculator.tambah();
        Assertions.assertEquals(17, result, "Ini adalah Tes Method Tambah");
    }

    @Test
    @Order(2)
    void testKurang() {
        //Create obj calculator, assign a dan b
        Calculator calculator = new Calculator(result, 5);

        result = calculator.kurang();

        Assertions.assertEquals(12, result, "Ini adalah Tes Method Kurang");
    }

    @Test
    //Untuk matiin testcase
    @Disabled
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
