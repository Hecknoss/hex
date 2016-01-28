class Fibo {
	
	public int fibCount(int max) {
		int a = 0;
		int b = 1;
		int c = a + b;
		
		while (c < max) {
			System.out.println(c);
			a = b;
			b = c;
			c = a + b;
		}
	return c;
	}
	
	public static void main (String argv[]){
		Fibo Fibo500 = new Fibo();
		Fibo500.fibCount(1000);
	}
}
