package calculator;

import java.util.List;

public class Calculator {
    public Integer sum(List<Integer> numList){
        int result = 0;

        for(Integer num : numList){
            if(num == null){
                throw new IllegalArgumentException("숫자가 아닌 null 값이 포함되어 있습니다.");
            }

            if(num < 0){
                throw new IllegalArgumentException("음수 값이 포함되어 있습니다.");
            }

            result += num;
        }

        return result;
    }
}
