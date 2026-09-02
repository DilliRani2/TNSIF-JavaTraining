package interfaceandwrapperclass.dayfive;


interface Demo{
	
	//final static 
	//int a = 10;
	
	//public abstract 
	void display();
	
	//void show();
	
}

class Demo_Class implements Demo{
	
	public void display() {
		System.out.println("Implementing the Demo");
	}
	
	
}

public class InterfaceDemo {

	public static void main(String[] args) {
		
		Demo_Class dc = new Demo_Class();
		dc.display();
		

	}

}
