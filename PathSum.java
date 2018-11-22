/*
 * Solution to https://projecteuler.net/problem=18
Content of text file loaded by this class:
75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
*/

import java.io.*;

public class PathSum {

	String fromFile;
	String text;
	int count;

	//constructor loads txt file, turns content into string,
	//and counts the lines in the file.
	public PathSum(String file) throws IOException {
		this.fromFile = file;

		try(BufferedReader br =  new BufferedReader(new FileReader(fromFile))) {

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while(line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
				this.count++;
			}
			this.text = sb.toString();
		}
	}

	//returns number of lines in file.
	public int getLineNum (){
		return count;
	}
	//returns content of file as string.
	public String getContent(){
		return text;
	}

	//turns string into formatted array
	public int[][] contentBuilder(int size) {
		int x = 0;
		int y = 0;
		int end = text.length();
		String dis = "";
		Integer num;
		int[][] ray = new int[size][size];

		for(int i = 0; i < end; i++) {

			if(text.charAt(i) == '\n') {
				dis = text.substring(i - 2, i);
				num = Integer.valueOf(dis);
				ray[y][x] = num;
				x = 0;
				y++;
			}
			if(text.charAt(i) == ' ') {
				dis = text.substring(i - 2, i);
				num = Integer.valueOf(dis);
				ray[y][x] = num;
				x++;
			}
		}
		return ray;
	}

	public int bigger(int a, int b) {
		if(a > b) {
			return a;
		}
		return b;
	}

	//Searches the paths and finds the biggest result.
	public int calculation(int ray[][]) {
		int[] x = new int[count];
		int total = 0;
		int biggest;
		int temp;
		int paths = 1;

		System.out.println("Path: " + paths);
    //the all zeros x loop
    //simple array printer.
    for(int y = 0; y < count; y++) {
			temp = x[y];
      System.out.println(ray[y][temp]);
			total = total + ray[y][temp];
    } //end array printer.
		System.out.println("total = " + total);
		biggest = total;
		total = 0;

    //loop to run through the whole x array from start to finish
    for(int z = 0; z < count -1; z++) {

      //wave loop to run a +1 wave through the array.
      for(int i = 0; i < count -1; i++) {
        if (x[count-1 - i] < count-1 - i) {
            x[count-1 - i]++;
        } else { break; }
				paths++;
        System.out.println("Path: " + paths);

        //simple array printer.
        for(int y = 0; y < count; y++) {
					temp = x[y];
          System.out.println(ray[y][temp]);
					total = total + ray[y][temp];
        } //end array printer.

				System.out.println("total = " + total);
				biggest = bigger(biggest, total);
				total = 0;
      } //end inner loop
    } //end outter loop

		return biggest;
	}

	public static void main(String[] args) throws IOException {

		String file = "pathsum.txt";
		PathSum thisone = new PathSum(file);
		int num = thisone.getLineNum();
		String stuff = thisone.getContent();
		int[][] rayray = thisone.contentBuilder(num);

		System.out.println(stuff + "\n" + num + " lines");

		int answer = thisone.calculation(rayray);
		System.out.println("The biggest mudda chuckin number is: " + answer);
	}
}
