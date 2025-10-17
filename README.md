# 문자열 계산기

## 기본 조건
입력받는 문자열은 구분자와 양수의 조합
기본 구분자는 , 와 :
빈 문자열 혹은 공백 문자열이 입력될 시 0을 반환
커스텀 구분자는 문자열 앞부분의 // 와 \n 사이에 위치하는 문자
잘못된 입력값이 들어올 시 IllegalArgumentException 에러를 던지고 프로그램 종료

## 필요 Class
- Application(입출력 전용)
- StringCal(Application에서 호출하는 중간 계층)
- InputValidator(입력 값 자체의 오류를 확인)
- Separator(입력 값에서 숫자와 커스텀 구분자를 분리)
- Calculator(최종적으로 숫자를 더하는 계산)
- ApplicationTest(통합 테스트)
- StringCalTest(StringCal 클래스 용 단위 테스트)
- ValidatorTest(InputValidator 클래스 용 단위 테스트)
- SeparatorTest(Separator 클래스 용 단위 테스트)
- CalculatorTest(Calculator 클래스 용 단위 테스트)

## 동작 흐름도
1. Application 실행 시 Console 을 통해 문자열을 입력 받는다.
2. StringCal에서 받은 문자열을 기반으로 InputValidator, Separator, Calculator을 차례대로 실행한다.
3. InputValidator 내에서 문자열이 비정상 값인지 확인 후 이상 없으면 문자열을 다시 넘기고 이상 있으면 IllegalArgumentException Error
4. Separator 내에서 문자열을 분리
   4-1. 문자열이 //로 시작하지 않으면 , 와 : 만을 이용해 구분
   4-2. 문자열이 //로 시작하면 커스텀 구분자를 구분자 리스트에 추가
   4-3. 최종적으로 숫자로만 구성된 리스트를 넘김
5. Calculator에서 리스트 반복을 돌며 숫자의 총합을 구한 뒤 최종 값을 넘김
6. Application에서 최종 값을 정해진 출력 형식에 맞게 가공해서 출력

## 예외 케이스
1. 입력 값이 음수로 들어오는 경우
2. 문자열의 시작이 // 이지만 \n이 문자열 내에 존재하지 않는 경우
3. 문자열이 // 로 시작하지 않음에도 , 와 : 를 제외한 문자가 들어있는 경우
