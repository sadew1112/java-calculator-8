package calculator;

import org.junit.jupiter.api.Test;

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
    void null_값이_포함되면_예외발생() {
        assertThatThrownBy(() -> calculator.sum(List.of(1, null, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
