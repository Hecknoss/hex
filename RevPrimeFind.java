package learn;

//reverse prime search for big numbers

class RevPrimeFind {
	
	public static long Primes(long max){
		
		if(max < 4){
			return max;
		}
				
		while(max > 0){
			int count = 0;
			long i = 1L;
			while(i < (Math.sqrt(max))){
				if(max % i == 0){
					count++;
					//System.out.println(max + " % " + i + " = " + (max % i));
					//System.out.println(count);
				}
				if(count > 1){
					//System.out.println(max + " is not a prime");
					break;
				}
				i++;
			}
			if(count < 2){
				return max;
			}
			max--;
		} return 0;
	}
	
	public static void main(String args[]){
		
		long num = 600851475143L; //change this value.
		
		System.out.println("the biggest prime number in " + num + " is: " + RevPrimeFind.Primes(num));
	}
}
