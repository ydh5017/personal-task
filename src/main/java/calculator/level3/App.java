package calculator.level3;

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in); // 스캐너 객체 생성

    public static void main(String[] args) {
        Parser parser = new Parser(); // Parser 객체 생성
        boolean continueLoop = true;

        // exit로 종료 전 까지 계산기 반복
        while (continueLoop) {
            // 사칙 연신 or 원의 넓이 계산 타입 지정
            String typeInput = toTypeInput(parser);

            // 원 넓이 계산
            if ("circle".equals(typeInput)) {
                circle(parser);
            }else {
                arithmetic(parser);
            }

            // 다음 행위
            continueLoop = actType(parser, typeInput);
        }
    }

    private static String toTypeInput(Parser parser) {
        // 사칙 연신 or 원의 넓이 계산 타입 지정
        boolean type = false;
        String typeInput = "";
        while (!type) {
            try {
                System.out.println("operation : 사칙 연산, circle : 원의 넓이 계산"); // 계산 타입 입력 요청 메시지 출력
                typeInput = sc.nextLine(); // 계산 타입 변수에 저장
                type = parser.setCalculateType(typeInput); // Parser 객체의 setCalculateType 메소드를 통해 타입 파싱 후 true 반환
            }catch (Exception e) {
                System.out.println(e.getMessage()); // 예외 메시지 출력
            }
        }
        return typeInput;
    }

    private static void circle(Parser parser) {
        // 원 넓이 계산
        String radiusInput;
        boolean radius = false;
        while (!radius) {
            try {
                System.out.println("반지름을 입력해 주세요."); // 반지름 입력 요청 메시지 출력
                radiusInput = sc.nextLine(); // 반지름 변수에 저장
                radius = parser.inputRadius(radiusInput); // Parser 객체의 inputRadius 메소드를 통해 반지름 파싱 후 true 반환
            }catch (Exception e) {
                System.out.println(e.getMessage()); //예외 메시지 출력
            }
        }
        System.out.println("원의 넓이 : "+parser.getCircleArea()); // 계산 결과 출력
    }

    private static void arithmetic(Parser parser) {
        boolean isValid = false;
        while (!isValid) {
            try {
                // 첫 번째 숫자
                System.out.println("첫 번째 숫자를 입력해주세요."); // 첫 번째 숫자 입력 요청 메시지 출력
                parser.inputFirstNumber(sc.nextLine()); // Parser 객체의 inputFirstNumber 메소드를 통해 첫 번째 숫자 파싱 후 true 반환

                // 사칙 연산 기호
                System.out.println("사칙연산 기호를 입력해주세요."); // 사칙연산 기호 입력 요청 메시지 출력
                parser.inputOperation(sc.nextLine()); // Parser 객체의 inputOperation 메소드를 통해 연산 기호 파싱 후 true 반환

                // 두 번째 숫자
                System.out.println("두 번째 숫자를 입력해주세요."); // 두 번째 숫자 입력 요청 메시지 출력
                parser.inputSecondNumber(sc.nextLine()); // Parser 객체의 inputFirstNumber 메소드를 통해 두 번째 숫자 파싱 후 true 반환

                isValid = true;
            }catch (Exception e) {
                System.out.println(e.getMessage()); // 예외 메시지 출력
            }
        }
        // 연산 결과
        double result = parser.executeCalculator();
        System.out.println("연산 결과 : " + result);
    }

    private static boolean actType(Parser parser, String typeInput) {
        // 다음 행위
        String action = "";
        boolean isExit = false;
        while (!isExit) {
            System.out.println("exit : 종료 / remove : 첫 번째 값 삭제 / inquiry : 연산 결과 리스트 출력 / 숫자 입력 : 입력 값보다 큰 연산 결과 값 출력 / enter 또는 아무 문자열 입력 시 계속 계산 진행"); // 다음 행위 입력 요청 메시지 출력
            action = sc.nextLine(); // 변수에 저장

            isExit = parser.ContinueByAction(action, typeInput);
        }
        if ("exit".equals(action)) { // exit 입력 시 false 반환 그 외에는 true 반환
            return false;
        }
        return true;
    }
}
