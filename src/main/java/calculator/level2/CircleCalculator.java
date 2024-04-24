package calculator.level2;

import java.util.ArrayList;
import java.util.List;

public class CircleCalculator extends Calculator {
    private double radius; // 반지름
    private static final double PI = 3.14159265358979323846; // 파이 값은 변하지 않기 때문에 final로 상수로 지정하고, static으로 전역 변수로 지정하여 데이터를 공유

    public CircleCalculator() {}

    public CircleCalculator(double radius) {
        this.radius = radius;
    }

    public CircleCalculator(double radius, List<Double> resultList) {
        this.radius = radius;
        this.resultList = resultList;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculate() {
        double result = PI * radius * radius;
        resultList.add(result);
        return result;
    }
}
