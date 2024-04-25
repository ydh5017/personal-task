package calculator.level3;

import java.util.ArrayList;
import java.util.List;

public abstract class Calculator<T> {
    List<T> resultList = new ArrayList<>(); // 연산 결과 리스트

    public Calculator() {}

    public Calculator(List<T> resultList) {
        this.resultList = resultList;
    }

    public abstract double calculate();

    public void removeFirstIndex() { // 리스트의 첫 번째 인덱스 삭제
        resultList.remove(0);
    }

    public void showResultList() { // 리스트 모두 출력
        resultList.forEach(System.out::println);
    }

    public void showListWithEnteredNumber(String number) { // 연산 결과 리스트에서 입력 값 보다 큰 값들 출력
        double parsedNumber = Double.parseDouble(number); // 입력 값 double로 형변환
        resultList.stream()
                .filter(f -> (double) f > parsedNumber) // 연산 결과 리스트에서 입력 값 보다 큰 값인 경우
                .forEach(System.out::println); // 출력
    }
}
