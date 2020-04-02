package myself;

public class TalkQuestion0401 {
	
	// split 메소드, StringTokenizer 사용금지
	
	public static void main(String[] args) {
		String str = "PROD-001#X-note#Samsung#3#6000000";
		String[] strs = stringSplit(str, "#");
		System.out.println("==== 문자열 처리 결과 ====");
		for(int i=0; i< strs.length; i++) {
			System.out.println(strs[i]);
		}
	}
	
	private static String[] stringSplit(String str1, String str2) {
		// 반환값이 String[]이므로 먼저 반환을 위한 배열을 생성한다.
		String[] strs = null;
		
		// 만약 주어진 str1이 null이라면 즉시 null값을 return한다. (방어적 코딩)
		if(str1 == null) {
			return strs;
		}
		
		// 단어의 개수를 구한다.
		// strs 배열은 str1에 속한 단어 개수만큼의 index를 요구하기 때문에, 배열의 길이를 알기 위함이다.
		// #으로 단어가 구분될 때마다 개수가 1씩 추가되고, 기본으로 한 단어는 존재하기 때문에 wordCount는 1로 시작한다.
		int wordCount=1; 
		// 문자열의 각 문자를 개별 항으로 갖는 char배열을 만든다.
		char[] charArr = str1.toCharArray();
		for (int i =0; i<charArr.length; i++) {
			// charArr 배열에서 #을 만날 때마다 단어의 개수를 하나씩 추가한다.
			if(str2.equals(charArr[i]+"")) {
				wordCount++;
			}
		}
		
		// 위에서 구한 단어의 개수를 바탕으로 새 배열을 만든다.
		strs = new String[wordCount];
		
		//만약 문자열에 포함된 단어가 하나뿐이라면(단어 경계 표지인 #을 만나지 못했다면) 그대로 주어진 문자열을 배열의 [0]항에 넣고 반환한다.
		if(wordCount==1) {
			strs[0] = str1;
			return strs;
		}
		
		// 그렇지 않다면 문자열 배열을 null이 아닌 "" 값으로 초기화한다.
		for(int i=0; i<wordCount; i++) {
			strs[i] ="";
		}
		
		// 현재까지 strs 배열에 입력된 단어의 개수를 파악하기 위해 count변수를 만든다.
		int count=0;
		
		for(int i=0; i<charArr.length;i++) {
			// charArr배열을 반복해서 돌리다가 #을 발견하면 단어 경계를 만난 것이므로 count를 늘리고 해당되는 항은 반복에서 제외한다. 
			if(str2.equals(charArr[i]+"")) {
				count++;
				continue;
			}
			
			// if()조건과 조건 사이에는 [count]번째 항에 계속해서 charArr[i]의 값을 문자열로 변환하여 누적시킨다.
			strs[count] +=charArr[i]+"";
		}
		
		// 완성된 배열을 return한다
		return strs;
	}
	
}
