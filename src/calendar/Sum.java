package calendar;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		int a, b;
		System.out.println("두 수의 합을 입력하세요. : ");
		
		Scanner scanner = new Scanner(System.in);
		String inputValue1, inputValue2;
		
		inputValue1 = scanner.next();
		inputValue2 = scanner.next();
		
		a = Integer.parseInt(inputValue1);
		b = Integer.parseInt(inputValue2);
		
//		System.out.println("두 수의 합은 " + (a + b)+ "입니다.");
		System.out.printf("%d와 %d의 합은 %d입니다.", a, b, a + b);
		scanner.close();
	}
}
