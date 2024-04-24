package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {

    private static final String OPERATION_REG = "[+\\-*/]"; // 사칙 연산 기호 정규식
    private static final String NUMBER_REG = "^[0-9]*$"; // 숫자만 허용하는 정규식

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 스캐너 객체 생성
        Calculator calculator = new Calculator(); // 계산기 객체 생성
        String exit = "";
        double[] results = new double[10];
        int count = 0;

        for (int i = 0; i < 10; i++) {
            // 첫 번째 숫자
            System.out.println("첫 번째 숫자를 입력해주세요."); // 첫 번째 숫자 입력 요청 메시지 출력
            String firstInput = sc.nextLine(); // 사용자가 입력한 첫 번째 숫자 변수에 저장
            while (!Pattern.matches(NUMBER_REG, firstInput)) { // 입력값이 숫자가 아닌 경우
                System.out.println("잘못된 입력입니다. 정수값을 입력해주세요.");
                firstInput = sc.nextLine();
            }
            calculator.setFirstNumber(Integer.parseInt(firstInput));

            // 사칙 연산 기호
            System.out.println("사칙연산 기호를 입력해주세요."); // 사칙연산 기호 입력 요청 메시지 출력
            String operator = sc.nextLine(); // 사용자가 입력한 사칙연산 기호 문자열을 변수에 저장
            while (!Pattern.matches(OPERATION_REG, operator)) { // 입력값이 사칙 연산 기호가 아닌 경우
                System.out.println("잘못된 입력입니다. 사칙 연산 기호를 입력해주세요.");
                operator = sc.nextLine();
            }
            calculator.setOperation(operator);

            // 두 번째 숫자
            System.out.println("두 번째 숫자를 입력해주세요."); // 두 번째 숫자 입력 요청 메시지 출력
            String secondInput = sc.nextLine(); // 사용자가 입력한 두 번째 숫자 변수에 저장
            while (!Pattern.matches(NUMBER_REG, secondInput) // 입력값이 숫자가 아닌 경우
                    || calculator.getOperation().equals("/") && secondInput.equals("0")) { // 나눗셈 연산일 때 분모가 0일 경우
                if (!Pattern.matches(NUMBER_REG, secondInput)) {
                    System.out.println("잘못된 입력입니다. 정수값을 입력해주세요.");
                } else if (calculator.getOperation().equals("/") && secondInput.equals("0")) {
                    System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                }
                secondInput = sc.nextLine();
            }
            calculator.setSecondNumber(Integer.parseInt(secondInput));

            // 연산 결과
            double result = calculator.calculate();
            System.out.println("연산 결과 : " + result);
            results[i] = result;
            count = i;


            if (i < 10) {
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                exit = sc.nextLine();
            }
            if (exit.equals("exit")) {
                break;
            }
        }
        for (int i = 0; i <= count; i++) {
            System.out.println(results[i]);
        }
    }
}
