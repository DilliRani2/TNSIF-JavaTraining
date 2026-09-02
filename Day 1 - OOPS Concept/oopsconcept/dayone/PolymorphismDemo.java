package oopsconcept.dayone;

//Method Overloading
class MathOp{
	
	public int add(int a, int b) {
		return a + b;
	}
	
	
	public float add(float a, int b) {
		return a + b;
	}
}


//Method Overriding
class Animal{
	void sound() {
		System.out.println("The sound is not declared");
	}
}


class Cat extends Animal{
	
	public void sound() {
		System.out.println("The cat is meowing.......");
	}
}


public class PolymorphismDemo {
	
	

	public static void main(String[] args) {
		
		MathOp mo = new MathOp();
		System.out.println(mo.add(10, 20));
		System.out.println(mo.add(25.5f, 10));
		
		Cat c = new Cat();
		c.sound();
		

	}

}
