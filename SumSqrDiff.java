package learn;
/*
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/

class SumSqrDiff {
	public static void calc(int num)
	{
		int count = 1;
		int addTotal = 0;
		while(count <= num)
		{
			addTotal += count;
			count++;
		}
		long sumTotal = (long) Math.pow(addTotal, 2);
		System.out.println("Square of the sum = " + sumTotal);
		
		count = 1;
		int sqrTotal = 0;
		while(count <= num)
		{
			sqrTotal += Math.pow(count, 2);
			count++;
		}
		System.out.println("Sum of the Square = " + sqrTotal);
		System.out.println("Difference = " + (sumTotal - sqrTotal));
	}
	
	public static void main(String args[])
	{
		SumSqrDiff.calc(10);
	}
}
