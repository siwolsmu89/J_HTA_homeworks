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
		String[] strs = null;
		if(str1 == null) {
			return strs;
		}
		int wordCount=1; // 단어개수 (strs.length=words)
		char[] charArr = str1.toCharArray();
		for (int i =0; i<charArr.length; i++) {
			if(str2.equals(charArr[i]+"")) {
				wordCount++;
			}
		}
		
		strs = new String[wordCount];
		if(wordCount==1) {
			strs[0] = str1;
			return strs;
		}
		for(int i=0; i<wordCount; i++) {
			strs[i] ="";
		}
		int count=0;
		for(int i=0; i<charArr.length;i++) {
			if(str2.equals(charArr[i]+"")) {
				count++;
				continue;
			}
			strs[count] +=charArr[i]+"";
		}
		
		
		return strs;
	}
	
}
