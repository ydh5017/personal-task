package calculator.level2;

import java.util.ArrayList;
import java.util.List;

public class Circle {
    private static double radius; // 반지름
    private final double PI = 3.14159265358979323846;
    private List<Double> areaList = new ArrayList<>();


    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, List<Double> areaList) {
        this.radius = radius;
        this.areaList = areaList;
    }

    public static double getRadius() {
        return radius;
    }

    public static void setRadius(double radius) {
        Circle.radius = radius;
    }

    public double getArea() {
        double area = PI * radius * radius;
        areaList.add(area);
        return area;
    }

    public void showAreaList() {
        areaList.forEach(System.out::println);
    }

    public void removeFirstIndex() {
        areaList.remove(0);
    }
}
