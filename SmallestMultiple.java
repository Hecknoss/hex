package learn;

import java.io.*;
/*
 * smallest postive number that is evenly divisible by
 * all of the numbers from 1 to 20/
 * https://projecteuler.net/problem=5
*/

class SmallestMultiple
{
	public static int smellsSmall(int nummie)
	{
		int num = nummie;
		int y = nummie;
		int count;
		int inc = nummie;
				
		while(true)
		{
			count = 0;
			int x = 1;
			
			while(x < num + 1)
			{
				if(y % x != 0)
				{
					System.out.println(y + " % " + x + " = " + y%x);
					break;
				}
				count++;
				x++;
				System.out.println("count = " + count);
			}	
			
			if(count > num - 1)
			{
				return y;
			}
			
			y += inc;
		}
		
	}
	
	public static void main(String[] args)
	{
		int number = 20;
		SmallestMultiple Smelly = new SmallestMultiple();
		System.out.println(Smelly.smellsSmall(number));
		
		
	}

}
