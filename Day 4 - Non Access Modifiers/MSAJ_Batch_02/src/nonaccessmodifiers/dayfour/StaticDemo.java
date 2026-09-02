package nonaccessmodifiers.dayfour;

public class StaticDemo {
	
	static int count; //static variable
	int data; //
	
	static { //static block
		count = 25;
		//data = 10;
		System.out.println("This is static count");
		
	}
	
	static void display() {
		System.out.println("The static variable count is: "+count);
	}
	

	public static void main(String[] args) {
		
		System.out.println("This is main method");
		
		display();
		

	}

}
