package calculator.level2.operator;

public class DivideOperator extends Operator {
    @Override
    public double operate(int firstNumber, int secondNumber) {
        return (double) firstNumber / secondNumber;
    }
}
