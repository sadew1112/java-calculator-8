package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈문자열_입력시() {
        assertSimpleTest(() -> {
            run("  ");  // 빈 문자열
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀구분자_예외_테스트() { // //로 시작하지만 뒤에 \n이 없는 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자_테스트() {
        assertSimpleTest(() -> {
            run("1,3:5,7");
            assertThat(output()).contains("결과 : 16");
        });
    }

    @Test
    void 커스텀_구분자_테스트2() {
        assertSimpleTest(() -> {
            run("//;\\n2;3;4");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 커스텀_구분자_테스트3() {
        assertSimpleTest(() -> {
            run("//!!\\n2!!3!!4,5");
            assertThat(output()).contains("결과 : 14");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
