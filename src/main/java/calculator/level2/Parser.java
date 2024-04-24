package calculator.level2;

import calculator.level2.exception.InputException;

import java.util.regex.Pattern;

public class Parser {

    private static final String OPERATION_REG = "[+\\-*/]"; // 사칙 연산 기호 정규식
    private static final String NUMBER_REG = "^[0-9]*$"; // 숫자만 허용하는 정규식

    ArithmeticCalculator Arithmetic = new ArithmeticCalculator(); // 계산기 객체 생성
    CircleCalculator circle = new CircleCalculator(); // Circle 객체 생성

    public boolean inputFirstNumber(String number) throws Exception {
        if (!Pattern.matches(NUMBER_REG, number)) { // 입력값이 숫자가 아닌 경우
            throw new InputException("정수값"); // 예외 처리
        }
        Arithmetic.setFirstNumber(Integer.parseInt(number)); // 계산기 객체 firstNumber 필드 설정
        return true;
    }

    public boolean inputOperation(String operation) throws Exception {
        if (!Pattern.matches(OPERATION_REG, operation)) { // 입력값이 사칙 연산 기호가 아닌 경우
            throw new InputException("사칙 연산 기호"); // 예외 처리
        }
        Arithmetic.setOperation(operation);
        return true;
    }

    public boolean inputSecondNumber(String number) throws Exception {
        if (!Pattern.matches(NUMBER_REG, number)) { // 입력값이 숫자가 아닌 경우
            throw new InputException("정수값"); // 예외 처리
        } else if (Arithmetic.getOperation().equals("/") && number.equals("0")) { // 나눗셈 연산일 때 분모가 0일 경우
            throw new Exception("나눗셈 연산에서 분모에 0이 입력될 수 없습니다."); // 예외 처리
        }
        Arithmetic.setSecondNumber(Integer.parseInt(number)); // 계산기 객체 secondNumber 필드 설정
        return true;
    }

    public double executeCalculator() {
        return Arithmetic.calculate(); // 연산 수행
    }

    public boolean ContinueByAction(String action, String type) {
        if (action.equals("remove")) {
            if (type.equals("operation")) {
                Arithmetic.removeFirstIndex(); // List 첫 번째 요소 삭제
            }else if (type.equals("circle")) {
                circle.removeFirstIndex(); // List 첫 번째 요소 삭제
            }
        }else if (action.equals("inquiry")) {
            if (type.equals("operation")) {
                Arithmetic.showResultList(); // List 모두 출력
            }else if (type.equals("circle")) {
                circle.showResultList(); // List 모두 출력
            }
        }else {
            return true;
        }

        return true;
    }

    public boolean setCalculateType(String type) throws Exception{
        if (type.equals("operation")) { // 타입이 사칙 연산인 경우
            return true;
        }else if (type.equals("circle")) { // 타입이 원 넓이 계산인 경우
            return true;
        } else {
            throw new InputException("타입"); // 예외 처리
        }
    }

    public boolean inputRadius(String radius) throws Exception{
        if (!Pattern.matches(NUMBER_REG, radius)) { // 입력값이 정수가 아닌 경우
            throw new InputException("정수값(반지름)"); // 예외 처리
        }
        circle.setRadius(Double.parseDouble(radius)); // 반지름을 생성자로 초기화한 Circle 객체 생성
        return true;
    }

    public double getCircleArea() {
        return circle.calculate(); // 원 넓이 계산
    }
}
