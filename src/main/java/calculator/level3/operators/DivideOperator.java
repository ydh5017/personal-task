package calculator.level3.operators;

public class DivideOperator extends Operator {
    @Override
    public double operate(int firstNumber, int secondNumber) {
        return (double) firstNumber / secondNumber;
    }
}
