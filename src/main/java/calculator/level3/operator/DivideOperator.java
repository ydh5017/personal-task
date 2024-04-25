package calculator.level3.operator;

public class DivideOperator extends Operator {
    @Override
    public double operate(int firstNumber, int secondNumber) {
        return (double) firstNumber / secondNumber;
    }
}
