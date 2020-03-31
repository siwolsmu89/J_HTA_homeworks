package homework;

import java.util.Scanner;

public class OxQuizDemo {

	public static void main(String[] args) {

		OxResults oxr = new OxResults();
		Scanner scanner = new Scanner(System.in);

		int quizNum = 0;
		String[] results;

		System.out.print("퀴즈 문항 수를 입력하세요: ");
		quizNum = scanner.nextInt();
		
		oxr.getResultArray(quizNum);

		while (true) {
			for (int i = 0; i < quizNum; i++) {
				System.out.print("[" + (i + 1) + "]번째 문항의 결과를 입력하세요(O 또는 X): ");
				String result = scanner.next();

				oxr.inputScore(result);
			}

			System.out.print("결과 입력이 끝나셨습니까?(O 또는 X) ");
			String inputEnd = scanner.next();

			if (inputEnd.equals("O")) {
				break;
			}
		}

		oxr.getScore();

	}

}
