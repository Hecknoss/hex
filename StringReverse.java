package learn;

class StringReverse {
	
	public static void main(String args[]){
	
	String word = "Speghetti";
	int len = word.length() - 1;
	System.out.println(word);
	int i = -1;
	int c = 0;
	String word2 = "";
	while (i < len){
		char cur = word.charAt(len);
		word2 += cur;
		//System.out.println("len = " + len + "\nc = " + c + "\nletter = " + cur + "\n");
		len -= 1;
		c += 1;
	}
	System.out.println(word2);
	}

}
