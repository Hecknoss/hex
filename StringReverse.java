package learn;

class StringReverse {
	
	public static String wordReverse(String wordie){
		String word = wordie;
		int len = word.length() - 1;
		System.out.println(word);
		int i = -1;
		int c = 0;
		String word2 = "";
		while (i < len){
			char cur = word.charAt(len);
			word2 += cur;
			len -= 1;
			c += 1;
		}
		return word2;
	}
	
	
	public static void main(String args[]){
		System.out.println(wordReverse("Spegetti"));

	}

}
