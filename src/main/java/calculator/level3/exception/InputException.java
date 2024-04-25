package calculator.level3.exception;

public class InputException extends Exception {
    public InputException(String message) {
        super("잘못된 입력입니다. " + message + "을/를 입력해주세요.");
    }
}
