package calculator.level3;

import calculator.level3.enums.OperatorType;

public class ArithmeticCalculator<T> extends Calculator { // 사칙 연산
    private T firstNumber;
    private T secondNumber;
    private String operator;


    public T getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(T firstNumber) {
        this.firstNumber = firstNumber;
    }

    public T getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(T secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operation) {
        this.operator = operation;
    }

    @Override
    public double calculate() { // 계산 수행
        double result = 0;
        switch (operator) {
            case "+": result = OperatorType.PLUS.calculate((Double) this.firstNumber, (Double) this.secondNumber); break;
            case "-": result = OperatorType.MINUS.calculate((Double) this.firstNumber, (Double) this.secondNumber); break;
            case "*": result = OperatorType.MULTIPLY.calculate((Double) this.firstNumber, (Double) this.secondNumber); break;
            case "/": result = OperatorType.DIVIDE.calculate((Double) this.firstNumber, (Double) this.secondNumber); break;
            case "%": result = OperatorType.MOD.calculate((Double) this.firstNumber, (Double) this.secondNumber); break;
        }
        resultList.add(result);
        return result;
    }
}
