package learn;

import java.util.Arrays;

/*
 * https://projecteuler.net/problem=9
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
*/

class PyTripOther 
{
	public static String[] addElement(String[] array, String next)
	{
		String[] array1 = Arrays.copyOf(array, array.length + 1);
		array1[array.length] = next;
		
		return array1;
	}

	public static void seeker(int max) 
	{
		int a = 1;
		int b = 2;
		int c = 3;
		int a2;
		int b2;
		int c2;
		String[] results = {};
		String other = "";

		while(c <= max)
		{
			//System.out.println("c = " + c);
			b = 2;
			while(b < c)
			{
				//System.out.println("b = " + b);
				a = 1;
				while(a < b)
				{
					//System.out.println("a = " + a);

					a2 = (int) Math.pow(a, 2);
					b2 = (int) Math.pow(b, 2);
					c2 = (int) Math.pow(c, 2);
					if(a2 + b2 == c2)
					{
						String win = a2 + " + " + b2 + " = " + c2;
						results = addElement(results, win);
						if(a + b + c == 1000)
						{
							other = a + " * " + b + " * " + c + " = " + (a*b*c);
						}

					}
					a++;
				}
				b++;
			}
			c++;
		}
		for(int i = 0; i < results.length; i++)
		{
			System.out.println(results[i]);
		}
		
		System.out.println(other);
	}
	
	public static void main(String[] args)
	{
		int max = 1000;
		seeker(max);
	}
}
