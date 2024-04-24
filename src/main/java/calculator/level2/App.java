package calculator.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Parser parser = new Parser(); // Parser 객체 생성
        Scanner sc = new Scanner(System.in); // 스캐너 객체 생성

        // exit로 종료 전 까지 계산기 반복
        while (true) {
            // 사칙 연신 or 원의 넓이 계산
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

            // 원 넓이 계산
            if (typeInput.equals("circle")) {
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
            }else {
                // 첫 번째 숫자
                System.out.println("첫 번째 숫자를 입력해주세요."); // 첫 번째 숫자 입력 요청 메시지 출력
                String firstInput = sc.nextLine(); // 사용자가 입력한 첫 번째 숫자 변수에 저장
                boolean first = false;

                while (!first) {
                    try {
                        first = parser.inputFirstNumber(firstInput); // Parser 객체의 inputFirstNumber 메소드를 통해 첫 번째 숫자 파싱 후 true 반환
                    }catch (Exception e) {
                        System.out.println(e.getMessage()); // 예외 메시지 출력
                        firstInput = sc.nextLine();
                    }
                }

                // 사칙 연산 기호
                System.out.println("사칙연산 기호를 입력해주세요."); // 사칙연산 기호 입력 요청 메시지 출력
                String operator = sc.nextLine(); // 사용자가 입력한 사칙연산 기호 문자열을 변수에 저장
                boolean operation = false;

                while (!operation) {
                    try {
                        operation = parser.inputOperation(operator); // Parser 객체의 inputOperation 메소드를 통해 연산 기호 파싱 후 true 반환
                    }catch (Exception e) {
                        System.out.println(e.getMessage()); // 예외 메시지 출력
                        operator = sc.nextLine();
                    }
                }

                // 두 번째 숫자
                System.out.println("두 번째 숫자를 입력해주세요."); // 두 번째 숫자 입력 요청 메시지 출력
                String secondInput = sc.nextLine(); // 사용자가 입력한 두 번째 숫자 변수에 저장
                boolean second = false;

                while (!second) {
                    try {
                        second = parser.inputSecondNumber(secondInput); // Parser 객체의 inputFirstNumber 메소드를 통해 두 번째 숫자 파싱 후 true 반환
                    }catch (Exception e) {
                        System.out.println(e.getMessage()); // 예외 메시지 출력
                        secondInput = sc.nextLine();
                    }
                }

                // 연산 결과
                double result = parser.executeCalculator();
                System.out.println("연산 결과 : " + result);
            }

            // exit : 종료, remove : 첫 번째 값 삭제, inquiry : 연산 결과 리스트 출력
            String action = "";
            boolean isExit = false;
            while (!isExit) {
                System.out.println("exit : 종료, remove : 첫 번째 값 삭제, inquiry : 연산 결과 리스트 출력"); // 다음 행동 입력 요청 메시지 출력
                action = sc.nextLine(); // 변수에 저장

                isExit = parser.ContinueByAction(action, typeInput);
            }
            if (action.equals("exit")) { // exit 입력 시 while문 종료
                break;
            }
        }
    }
}
