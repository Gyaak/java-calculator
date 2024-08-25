import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void addTest() {
        String input1 = "1,2";
        String input2 = "1,2,3";
        String input3 = "1,2:3";
        assertThat(calculator.add(input1)).isEqualTo(3);
        assertThat(calculator.add(input2)).isEqualTo(6);
        assertThat(calculator.add(input3)).isEqualTo(6);
    }

    @Test
    void customDelimiterTest() {
        String input = "//;\n1;2;3";
        assertThat(calculator.add(input)).isEqualTo(6);
    }

    @Test
    void exceptionTest() {
        String input1 = "1,-5,7";
        String input2 = "//a\n1a3ab";
        assertThatThrownBy(()-> calculator.add(input1)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(()-> calculator.add(input2)).isInstanceOf(RuntimeException.class);
    }
}
