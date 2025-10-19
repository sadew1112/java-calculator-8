package calculator;

public class InputValidator {

    public void validate(String input){
        if(input == null) {
            throw new IllegalArgumentException("입력 값이 null입니다.");
        }

        if(input.startsWith("//")){
            if (!input.contains("\\n")) {
                throw new IllegalArgumentException("커스텀 구분자 형식에 맞지 않습니다.");
            }

            if (count(input) > 1) {
                throw new IllegalArgumentException("\\n은 구분자로 사용하실 수 없습니다.");
            }
        }else{
            if (!input.matches("^[0-9,:]*$")) {
                throw new IllegalArgumentException(", 와 : 를 제외한 다른 문자가 포함되어 있습니다.");
            }
        }
    }

    private int count(String input) {
        String sep = "\\n";
        int count = 0;

        while (input.indexOf(sep) != -1) {
            int index = input.indexOf(sep);
            input = input.substring(index + 2);
            count++;
        }
        return count;
    }
}
