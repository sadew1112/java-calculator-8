package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void 숫자_리스트_합계_정상계산() {
        assertThat(calculator.sum(List.of(4, 7, 3))).isEqualTo(14);
    }

    @Test
    void 음수_포함시_예외발생() {
        assertThatThrownBy(() -> calculator.sum(List.of(1, -2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void null값_포함시_예외() {
        // List.of 는 불변 리스트 생성 + null 포함 불가 이므로 형식 변환
        assertThatThrownBy(() -> calculator.sum(Arrays.asList(1, null, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
