import org.assertj.core.internal.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 size()메소드를 활용해 Set의 크기를 확인")
    void 크기확인() {
        int expected = 3;
        assertThat(numbers.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("1,2,3값이 set에 존재하는지테스트")
    void 값존재테스트(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "4:false"}, delimiter = ':')
    @DisplayName("1,2,3값이 set에 존재하는지테스트")
    void 동적값존재테스트(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
