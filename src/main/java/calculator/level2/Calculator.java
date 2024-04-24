package calculator.level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private int firstNumber;
    private int secondNumber;
    private String operation;

    public Calculator() {}

    public Calculator(int firstNumber, int secondNumber, String operation, List<Double> resultList) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
        this.resultList = resultList;
    }

    private List<Double> resultList = new ArrayList<>(); // 연산 결과 리스트

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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double calculate() {
        double result = 0;
        switch (operation) {
            case "+": result = firstNumber + secondNumber; break;
            case "-": result = firstNumber - secondNumber; break;
            case "*": result = firstNumber * secondNumber; break;
            case "/": result = firstNumber / secondNumber; break;
        }
        resultList.add(result);
        return result;
    }

    public void deleteFirstIndex() {
        resultList.remove(0);
    }

    public void showResultList() {
        resultList.forEach(System.out::println);
    }
}
