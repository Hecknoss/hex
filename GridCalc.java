package learn;
import java.io.*;

class GridCalc {
	
	/*
	 * https://projecteuler.net/problem=11
	 */
	
	public static String FileLoad(String toBeLoad) throws IOException {
				
		try(BufferedReader br =  new BufferedReader(new FileReader(toBeLoad))) {
			
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while(line != null) {
				sb.append(line);
				//sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			return everything;
		} 		
	}
	
	public static String[] Sorter1(String everything) { // sorts into string array with 20 parts.
		
		int len = 60; 
		int max = 20;
		String[] all = new String[20];
		int start = 0;
		int end = len;
		
		for(int i = 0; i < max; i++) {
			all[i] = everything.substring(start, end);
			start = end;
			end += len;
		}
		return all;
	}
	
	public static int[] Sorter2(String line) {
		
		int start = 0;
		int[] result = new int[20];
		int count = 0;
		
		for(int i = 0; i < line.length(); i++) {

			if(line.charAt(i) == ' ') {
				
				Integer x = Integer.valueOf(line.substring(start, i));
				start = i + 1;
				result[count] = x;
				count++;
			}
		}
		return result;
	}
	
	public static int Horizontal(int[][] array) {
		int max = 0;
		int result;
				
		for(int i = 0; i < 20; i++) {
			int a = 0, b = 1, c = 2, d = 3;
			while(a < 17) {
				result = array[i][a] * array[i][b] * array[i][c] * array[i][d];
				a++;
				b++;
				c++;
				d++;
				if(result > max) {
					max = result;
				}
			}
		}
		return max;
	}
	
	
	public static int Vertical(int[][] array) {
		int max = 0;
		int result;
				
		for(int i = 0; i < 20; i++) {
			int a = 0, b = 1, c = 2, d = 3;
			while(a < 17) {
				result = array[a][i] * array[b][i] * array[c][i] * array[d][i];
				a++;
				b++;
				c++;
				d++;
				if(result > max){
					max = result;
				}
			}
		}
		return max;
	}
	
	
	public static int Diagonal(int[][] array) {
		int max = 0;
		int result, result2;
				
		for(int v = 0; v < 17; v++) {
			int v1 = v+1, v2 = v+2, v3 = v+3;
			for(int h = 0; h < 17; h++) {
				int h1 = h+1, h2 = h+2, h3 = h+3;
				result2 = array[v][h] * array[v1][h1] * array[v2][h2] * array[v3][h3];
				
				if(result2 > max) {
					max = result2;
				}	
			}
		}
		
		
		for(int v = 0; v < 17; v++) {
			int v1 = v+1, v2 = v+2, v3 = v+3;
			
			for(int h = 3; h < 20; h++) {
				int h1 = h-1, h2 = h-2, h3 = h-3;
				result2 = array[v][h] * array[v1][h1] * array[v2][h2] * array[v3][h3];
				
				if(result2 > max) {
					max = result2;
				}	
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		String file = "numgrid.txt";
		String[] alls = Sorter1(FileLoad(file));
		int[][] all2d = new int[20][20];
		int horizontalMax, verticalMax, diagonalMax;
		
		for(int i = 0; i < alls.length; i++) {
			all2d[i] = Sorter2(alls[i]);
		}
		
		horizontalMax = Horizontal(all2d);
		verticalMax = Vertical(all2d);
		diagonalMax = Diagonal(all2d);
		
		System.out.println("horizontal = " + horizontalMax);
		System.out.println("vertical = " + verticalMax);
		System.out.println("diagonal = " + diagonalMax);
		
	}
}


/* WORKING
 * Grid is 20x20 and directions are vertical, horizontal, and diagonal.
 * numbers are two digits and separated by a space.
 * example hori:  [0][0] * [0][1] * [0][2] * [0][3]
 * example vert:  [0][0] * [1][0] * [2][0] * [3][0]
 * example diag1: [0][0] * [1][1] * [2][2] * [3][3]
 * example diag2: [0][3] * [1][2] * [2][1] * [3][0]
 * 
 * MAXIMUM PARAMETERS:
 * Horizontal first field:
 * first dimension: [0] to [20]
 * second dimension: [0] to [16]
 * etc...
 */
