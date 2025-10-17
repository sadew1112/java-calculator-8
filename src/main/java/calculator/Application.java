package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        StringCal stringCal = new StringCal(
                new InputValidator(),
                new Separator(),
                new Calculator()
        );

        System.out.print("결과 : " + stringCal.result(input));
    }
}
