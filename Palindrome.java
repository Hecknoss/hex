package learn;

//find the largest palindrome
//made from the product of two 3 digit numbers

class Palindrome {
	
	public int palin(int max){
		
		int pali = 0;
		int back = 0;
		int x = 111;
		int ans;
		int forw;
		int fx;
		int fy;
		
		//multiply two 3 digit numbers
		while(x < max){
			int y = 111;
			
			//count through all combinations
			while (y < x) {
				ans = y * x;
				forw = ans;
				back = 0;
				
				//reverse number
				while(forw != 0){
					back = (back*10) + (forw%10);
					forw = forw / 10;
				}
				
				//check palindrome and assign if largest
				if(ans == back && ans > pali){
					pali = ans;
					fx = x;
					fy = y;
					System.out.println(fx + " * " + fy + " = " + pali);
				}
				
				y++;
			}
		
			x++;
		}
		return pali;
	}
	
	public static void main(String args[]){
		
		int num = 1000; //change this number
		Palindrome numcheck = new Palindrome();
		System.out.println(numcheck.palin(num));
	
	}
}
