package scannerandbuffered.daythree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderDemo {

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter your name: ");
		String name = br.readLine();
		
		System.out.println("Welcome "+name);
		
		

	}

}
