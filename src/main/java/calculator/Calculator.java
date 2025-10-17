package calculator;

import java.util.List;

public class Calculator {
    public Integer sum(List<Integer> numList){
        int result = 0;

        for(Integer num : numList){
            if(num == null || num < 0){
                throw new IllegalArgumentException("숫자가 null 이거나 음수입니다.");
            }

            result += num;
        }

        return result;
    }
}
