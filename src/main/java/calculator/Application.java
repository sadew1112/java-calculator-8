package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        StringCal stringCal = new StringCal();
        int result = stringCal.result(input);
        System.out.print("결과 : " + result);
    }
}
