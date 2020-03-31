package myself;

public class programmers01 {
	
	public static int[] charArrToIntArr(char[] charArr) {
		char[] digits = charArr;
		int[] onlyDigits = null;
		
		if (digits[0]=='+'||digits[0]=='-') {
			onlyDigits = new int[digits.length-1];
			for (int i=0; i<onlyDigits.length; i++) {
				onlyDigits[i] = digits[i+1]-'0';
			}
		} else {
			onlyDigits = new int[digits.length];
			for (int i=0; i<onlyDigits.length; i++) {
				onlyDigits[i] = digits[i]-'0';
			}
		}
		return onlyDigits;
	}
	
	public static boolean checkPlus(char[] charArr) {
		char[] digits = charArr;
		boolean isPlus = true;
		
		if (digits[0]=='-') {
			isPlus = false;
		} 
		return isPlus;
	}
	
	public static int getArrToInt(int[] onlyDigits) {
		int result=0;
		
		for (int i=0; i<onlyDigits.length; i++) {
			result = result*10 + onlyDigits[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		String s = "1234";
		char[] digits = s.toCharArray();
		
		int[] onlyDigits = charArrToIntArr(digits);
		int answer = getArrToInt(onlyDigits);
		
		boolean isPlus=checkPlus(digits);
		if (!isPlus) {
			answer = (-answer);
		}
		
		System.out.println(answer);
	}
	
}
