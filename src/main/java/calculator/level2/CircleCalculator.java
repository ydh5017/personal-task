package calculator.level2;

import java.util.ArrayList;
import java.util.List;

public class CircleCalculator extends Calculator {
    private static double radius; // 반지름
    private final double PI = 3.14159265358979323846;

    public CircleCalculator() {}

    public CircleCalculator(double radius) {
        this.radius = radius;
    }

    public CircleCalculator(double radius, List<Double> resultList) {
        this.radius = radius;
        this.resultList = resultList;
    }

    public static double getRadius() {
        return radius;
    }

    public static void setRadius(double radius) {
        CircleCalculator.radius = radius;
    }

    @Override
    public double calculate() {
        double result = PI * radius * radius;
        resultList.add(result);
        return result;
    }
}
