package scannerandbuffered.daythree;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter college name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter counselling code: ");
		int code = sc.nextInt();
		
		System.out.println("The college name is: "+ name + " and the counselling code is: "+code);
 
		//sc.close();
	}

}
