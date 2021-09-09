package calendar;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Sum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputValue = scanner.nextLine();
		scanner.close();
		
		String[] inputStrList = inputValue.split(" ");
		
		int[] InputIntList = new int[2];
		InputIntList[0] = Integer.parseInt(inputStrList[0]);
		InputIntList[1] = Integer.parseInt(inputStrList[1]);
		
		int sum = IntStream.of(InputIntList).sum();
		System.out.println(sum);
		
	}
}
