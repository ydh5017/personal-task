package calculator.level2.operator;

public class ModOperator extends Operator {
    @Override
    public double operate(int firstNumber, int secondNumber) {
        return firstNumber % secondNumber;
    }
}
