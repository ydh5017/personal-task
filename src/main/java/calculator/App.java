package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫 번째 숫자를 입력해주세요.");
        String firstInput = sc.nextLine();

        System.out.println("두 번째 숫자를 입력해주세요.");
        String secondInput = sc.nextLine();
    }
}
