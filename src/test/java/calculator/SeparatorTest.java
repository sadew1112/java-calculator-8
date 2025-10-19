package calculator;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SeparatorTest {
    private final Separator separator = new Separator();
    @Test
    void 기본_구분자_테스트() {
        assertThat(separator.parse("1,2:3")).containsExactly(1, 2, 3);
    }

    @Test
    void 커스텀_구분자_테스트() {
        assertThat(separator.parse("//;\\n1;2;3")).containsExactly(1, 2, 3);
    }

    @Test
    void 구분자_혼용_테스트() {
        assertThat(separator.parse("//!\\n1!2,3:4")).containsExactly(1, 2, 3, 4);
    }

    @Test
    void 문자열_부분_공백_테스트() {
        assertThat(separator.parse("//!\\n")).containsExactly(0);
    }

    @Test
    void 단일_숫자_테스트() {
        assertThat(separator.parse("5")).containsExactly(5);
    }

    @Test
    void 구분자_반복_테스트() {
        assertThat(separator.parse("1,,2::3")).containsExactly(1, 2, 3);
    }

}
