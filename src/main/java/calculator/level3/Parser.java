package calculator.level3;

import calculator.level3.exception.InputException;

import java.util.regex.Pattern;

public class Parser {

    private static final String OPERATION_REG = "[+\\-*/%]"; // 사칙 연산 기호 정규식
    private static final String NUMBER_REG = "[0-9]+(.[0-9]+)?$"; // 숫자만 허용하는 정규식

    private String strOperation;

    ArithmeticCalculator<Double> arithmetic = new ArithmeticCalculator<>(); // 계산기 객체 생성
    CircleCalculator circle = new CircleCalculator(); // Circle 객체 생성

    public void inputFirstNumber(String number) throws Exception {
        if (!Pattern.matches(NUMBER_REG, number)) { // 입력값이 숫자가 아닌 경우
            throw new InputException("숫자"); // 예외 처리
        }
        arithmetic.setFirstNumber(Double.valueOf(number)); // 계산기 객체 firstNumber 필드 설정
    }

    public void inputOperation(String operation) throws Exception {
        if (!Pattern.matches(OPERATION_REG, operation)) { // 입력값이 사칙 연산 기호가 아닌 경우
            throw new InputException("사칙 연산 기호"); // 예외 처리
        }
        this.strOperation = operation;
        arithmetic.setOperator(operation);
    }

    public void inputSecondNumber(String number) throws Exception {
        if (!Pattern.matches(NUMBER_REG, number)) { // 입력값이 숫자가 아닌 경우
            throw new InputException("숫자"); // 예외 처리
        }
        if ("0".equals(number)) { // 나눗셈 연산일 때 분모가 0일 경우
            if ("/".equals(this.strOperation) || "%".equals(this.strOperation)) { // 나눗셈 연산일 때 분모가 0일 경우
                throw new Exception("나눗셈 연산에서 분모에 0이 입력될 수 없습니다."); // 예외 처리
            }
        }
        arithmetic.setSecondNumber(Double.valueOf(number)); // 계산기 객체 secondNumber 필드 설정
    }

    public double executeCalculator() {
        return arithmetic.calculate(); // 연산 수행
    }

    public boolean ContinueByAction(String action, String type) {
        if ("remove".equals(action)) {
            if ("operation".equals(type)) {
                arithmetic.removeFirstIndex(); // List 첫 번째 요소 삭제
                return false;
            }else if ("circle".equals(type)) {
                circle.removeFirstIndex(); // List 첫 번째 요소 삭제
                return false;
            }
        }else if ("inquiry".equals(action)) {
            if ("operation".equals(type)) {
                arithmetic.showResultList(); // List 모두 출력
                return false;
            }else if ("circle".equals(type)) {
                circle.showResultList(); // List 모두 출력
                return false;
            }
        }else if (Pattern.matches(NUMBER_REG, action)) {
            arithmetic.showListWithEnteredNumber(action);
            return false;
        }else {
            return true;
        }

        return true;
    }

    public boolean setCalculateType(String type) throws Exception{
        if ("operation".equals(type)) { // 타입이 사칙 연산인 경우
            return true;
        }else if ("circle".equals(type)) { // 타입이 원 넓이 계산인 경우
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
