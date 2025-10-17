package calculator;

import java.util.List;

public class StringCal {
    private final InputValidator validator;
    private final Separator separator;
    private final Calculator calculator;

    public StringCal(InputValidator validator, Separator separator, Calculator calculator) {
        this.validator = validator;
        this.separator = separator;
        this.calculator = calculator;
    }
    public int result(String input) {
        validator.validate(input);
        List<Integer> numList = separator.parse(input);
        return calculator.sum(numList);
    }
}
