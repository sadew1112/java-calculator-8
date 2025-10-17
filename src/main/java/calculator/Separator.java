package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Separator {
    public List<Integer> parse(String input){

        List<String> sepList = new ArrayList<>(List.of(",", ":"));

        if(input.startsWith("//")){
            int stdIndex = input.lastIndexOf("\\n");

            String custom = input.substring(2, stdIndex);
            String numStr = input.substring(stdIndex + 1);

            sepList.add(custom);

            return translate(sepList, numStr);
        }

        return translate(sepList, input);
    }

    private List<Integer> translate(List<String> sepList, String numStr) {
        for (String sep : sepList) {
            numStr = numStr.replace(sep, ",");
        }

        String[] numList = numStr.split(",");

        return Arrays.stream(numList)
                .filter(s -> s != null && !s.isBlank())
                .map(num -> Integer.parseInt(num))
                .collect(Collectors.toList());
    }

}
