package calculator.level2.exception;

public class InputException extends Exception {
    public InputException(String message) {
        super("잘못된 입력입니다. " + message + "를/을 입력해주세요.");
    }
}
