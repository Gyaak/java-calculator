
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split테스트_1과2() {
        String target = "1,2";
        String[] expected = {"1","2"};
        assertThat(target.split(",")).containsExactly(expected);
    }

    @Test
    void split테스트_1() {
        String target = "1";
        String[] expected = {"1"};
        assertThat(target.split(",")).containsExactly(expected);
    }

    @Test
    void 괄호제거() {
        String target = "(1,2)";
        String expected = "1,2";
        assertThat(target.substring(1,target.length()-1)).isEqualTo(expected);
    }

    @Test
    @DisplayName("\"abc\"값이 주어졌을 때, charAt메소드로 특정 위치의 문자 가져오기")
    void 특정위치문자() {
        String target = "abc";
        assertThat(target.charAt(0)).isEqualTo('a');
        assertThatThrownBy(()->target.charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
