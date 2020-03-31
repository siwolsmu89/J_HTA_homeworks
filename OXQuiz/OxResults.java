package homework;

public class OxResults {

	String[] results;
	int quizNum;
	int quizCount;
	
	void getResultArray(int quizNum) {
		this.quizNum = quizNum;
		results = new String[this.quizNum];
	}
	
	void inputScore(String result) {
		results[quizCount] = result;
		quizCount++;
	}
	
	void getScore() {
		int point = 0;
		int pointSum = 0;

		for (int i = 0; i < quizCount; i++) {
			if (results[i].equals("O")) {
				point++;
				pointSum += point;
			} else {
				point = 0;
			}
		}

		System.out.println(pointSum);
	}
}
