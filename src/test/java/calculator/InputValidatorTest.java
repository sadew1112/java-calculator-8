package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {
    private final InputValidator validator = new InputValidator();

    @Test
    void 정상_실행_예시1() {
        assertThatNoException()
                .isThrownBy(() -> validator.validate("2,3:4"));
    }

    @Test
    void 정상_실행_예시2() {
        assertThatNoException()
                .isThrownBy(() -> validator.validate("//;\\n1;3"));
    }


    @Test
    void null_예외발생() {
        assertThatThrownBy(() -> validator.validate(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 음수_포함시_예외발생() {
        assertThatThrownBy(() -> validator.validate("//1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀구분자_예외발생() {
        assertThatThrownBy(() -> validator.validate("//\\n\\n\\n1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
