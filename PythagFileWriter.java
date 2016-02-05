package learn;

import java.util.Arrays;
import java.io.*;

class PythagFileWriter {
	
	public static String[] addElement(String[] array, String next) {
		String[] array1 = Arrays.copyOf(array, array.length + 1);
		array1[array.length] = next;
		return array1;
	}
	
	public static String[] seeker(int max) {
		int a = 1;
		int b = 2;
		int c = 3;
		int a2;
		int b2;
		int c2;
		String[] results = {};
		
		while(c <= max) {
			//System.out.println("c = " + c);
			b = 2;
			while(b < c) {
				//System.out.println("b = " + b);
				a = 1;
				while(a < b) {
					//System.out.println("a = " + a);

					a2 = (int) Math.pow(a, 2);
					b2 = (int) Math.pow(b, 2);
					c2 = (int) Math.pow(c, 2);
					if(a2 + b2 == c2) {
						String win = a2 + " + " + b2 + " = " + c2;
						results = addElement(results, win);
					}
					a++;
				}
				b++;
			}
			c++;
		}
		return results;
	}

	public static void main(String[] args) throws IOException {
		int max = 100;
		String[] results = seeker(max);
		BufferedWriter bw = null;
		
		try {
			File dir = new File("test");
			File file = new File("test/output.txt");
			if(!dir.exists()) {
				dir.mkdir();
			}
						
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			for(int i=0; i<results.length; i++){
				String s = results[i] + "\n";
				bw.write(s);
			}
			System.out.println("File Written Successfully");
		
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		finally
		{
			try {
				if(bw!=null)
					bw.close();
			} catch(Exception ex){
				System.out.println("Error in closing the BufferedWriter"+ex);
			}
		}
	}
}
