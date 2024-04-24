package calculator.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Parser parser = new Parser(); // Parser 객체 생성
        Scanner sc = new Scanner(System.in); // 스캐너 객체 생성
        List<Double> resultList = new ArrayList<>(); // 연산 결과 리스트

        // exit로 종료 전 까지 계산기 반복
        while (true) {
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

            // exit : 종료, remove : 첫 번째 값 삭제, inquiry : 연산 결과 리스트 출력
            String action;
            while (true) {
                System.out.println("exit : 종료, remove : 첫 번째 값 삭제, inquiry : 연산 결과 리스트 출력");
                action = sc.nextLine();

                boolean isExit = parser.ContinueByAction(action);

                if (isExit) { // while문 종료
                    break;
                }
            }
            if (action.equals("exit")) { // exit 입력 시 while문 종료
                break;
            }
        }
    }
}
