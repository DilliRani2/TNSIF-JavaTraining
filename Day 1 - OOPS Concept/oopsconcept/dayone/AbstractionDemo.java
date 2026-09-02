package oopsconcept.dayone;

abstract class Shape{
	
	abstract void draw();//declaration
	
	void sketch() {
		
	}
}

class Circle extends Shape{
	
	void draw() {
		System.out.println("Drawing a circle....");
	}
}



public class AbstractionDemo {

	public static void main(String[] args) {
		
		Circle c = new Circle();
		c.draw();
		
		Shape s = new Circle();

	}

}
