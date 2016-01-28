package learn;

class PrimeFinder {
	
	public static long Primes(long max){
		
		long n = 2L;
		long bigOne = 0;
		
		while(n < max){
			long i = 1L;
			int count = 0;
			
			while(i < n){
				if(n % i == 0){
					count++;
					System.out.println(i + " % " + n + " = " + i/n);
				}
				i++;
				//System.out.println("i = " + i);
				if(count > 1){
					System.out.println(n + " is not a prime number");
					break;
				}
			}
			if(count < 2){
				System.out.println(n + " is a prime number");
				bigOne = n;
			}
			//System.out.println("n = " + n);
			n++;
		}
		return bigOne;
	}
	
	public static void main(String args[]){
		
		long num = 600851475143L; //change this value.
		
		System.out.println("the biggest prime number in " + num + " is: " + PrimeFinder.Primes(num));
	}
}
