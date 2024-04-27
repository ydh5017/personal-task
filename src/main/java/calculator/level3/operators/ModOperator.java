package calculator.level3.operators;

public class ModOperator extends Operator {
    @Override
    public double operate(int firstNumber, int secondNumber) {
        return firstNumber % secondNumber;
    }
}
