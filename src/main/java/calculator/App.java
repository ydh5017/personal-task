package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫 번째 숫자를 입력해주세요."); // 첫 번째 숫자 입력 요청 메시지 출력
        String firstInput = sc.nextLine(); // 사용자가 입력한 첫 번째 숫자 변수에 저장

        System.out.println("사칙연산 기호를 입력해주세요."); // 사칙연산 기호 입력 요청 메시지 출력
        String operator = sc.nextLine(); // 사용자가 입력한 사칙연산 기호 문자열을 변수에 저장

        System.out.println("두 번째 숫자를 입력해주세요."); // 두 번째 숫자 입력 요청 메시지 출력
        String secondInput = sc.nextLine(); // 사용자가 입력한 두 번째 숫자 변수에 저장
    }
}
