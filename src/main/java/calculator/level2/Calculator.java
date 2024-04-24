package calculator.level2;

import java.util.ArrayList;
import java.util.List;

public abstract class Calculator {
    List<Double> resultList = new ArrayList<>(); // 연산 결과 리스트

    public Calculator() {}

    public Calculator(List<Double> resultList) {
        this.resultList = resultList;
    }

    public abstract double calculate();

    public void removeFirstIndex() {
        resultList.remove(0);
    }

    public void showResultList() {
        resultList.forEach(System.out::println);
    }
}
