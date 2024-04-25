package calculator.level2;

import calculator.level2.operator.*;
import calculator.level3.OperatorType;

public class ArithmeticCalculator extends Calculator { // 사칙 연산
    private int firstNumber;
    private int secondNumber;
//    private Operator operator;
    private String operator;


    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String  getOperator() {
        return operator;
    }

    public void setOperator(String operation) {
//        switch (operation) {
//            case "+": this.operator = new AddOperator(); break;
//            case "-": this.operator = new SubtractOperator(); break;
//            case "*": this.operator = new MultiplyOperator(); break;
//            case "/": this.operator = new DivideOperator(); break;
//            case "%": this.operator = new ModOperator(); break;
//        }
        this.operator = operation;
    }

    @Override
    public double calculate() { // 계산 수행
        double result = 0;
        // Operator 추상 클래스의 operator 추상 메서드를 구현한 구현체로 숫자들을 넘겨 계산 후 double 값 리턴
//        result = this.operator.operate(this.firstNumber, this.secondNumber);
        switch (this.operator) {
            case "+": result = OperatorType.PLUS.calculate(firstNumber, secondNumber); break;
            case "-": result = OperatorType.MINUS.calculate(firstNumber, secondNumber); break;
            case "*": result = OperatorType.MULTIPLY.calculate(firstNumber, secondNumber); break;
            case "/": result = OperatorType.DIVIDE.calculate(firstNumber, secondNumber); break;
            case "%": result = OperatorType.MOD.calculate(firstNumber, secondNumber); break;
        }

        resultList.add(result);
        return result;
    }
}
