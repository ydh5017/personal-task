package calculator.level2.operator;

public abstract class Operator {
    // 오류 회고 : public을 잊고 추가 안 해서 객체를 생성해도 메서드 호출이 안됐다. public 추가하니 해결
    public abstract double operate(int firstNumber, int secondNumber);
}
