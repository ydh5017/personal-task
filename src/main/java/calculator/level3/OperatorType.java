package calculator.level3;

interface Operator {
    double calculate(double a, double b);
}

public enum OperatorType {
    PLUS ((x, y) -> x + y),
    MINUS ((x, y) -> x - y),
    MULTIPLY ((x, y) -> x * y),
    DIVIDE ((x, y) -> x / y),
    MOD ((x, y) -> x % y);

    private final Operator operator;

    OperatorType(Operator operator) {
        this.operator = operator;
    }

    public double calculate(double x, double y) {
        return operator.calculate(x, y);
    }
}