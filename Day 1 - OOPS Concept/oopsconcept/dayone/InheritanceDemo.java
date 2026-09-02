package oopsconcept.dayone;

//Single Inheritance

class Parent{
	
	void single() {
		System.out.println("This is single inheritance");
	}
}

class Child extends Parent{
	
	void child() {
		System.out.println("This is child single inheritance");
	}
	
}

class Animals{
	
	String name;
	
	//constructor
	
	Animals(String name){
		this.name = name;
	}
	
	void display() {
		System.out.println("Animal name: "+name);
	}
}

class Dog extends Animals {
	
	String breed;
	
	Dog(String breed, String name){
		super(name);
		
		this.breed = breed;
	}
	
	void show() {
		display();
		System.out.println("Dog breed: "+breed);
	}
	
}


//Multilevel

class GrandParent{
	void gp() {
		System.out.println("This is grand parent class");
	}
}

class Parent_01 extends GrandParent{
	void p() {
		System.out.println("This is parent class");
	}
}

class Child_01 extends Parent_01{
	void c() {
		System.out.println("This is child class");
	}
}

//Hierarchical Inheritance

class Fruits {
	
	void sweet() {
		System.out.println("The fruits are sweet");
	}
}


class Apple extends Fruits {
	
	void red() {
		System.out.println("The apples are sweet");
	}
}

class Mango extends Fruits {
	
	void yellow() {
		System.out.println("The maongoes are sweet");
	}
}

public class InheritanceDemo {

	public static void main(String[] args) {
		
		
		Child c = new Child();
		c.child();
		c.single();
		
		Child_01 c1 = new Child_01();
		c1.c();
		c1.gp();
		c1.p();
		
		Apple a = new Apple();
		a.red();
		a.sweet();
		
		Mango m = new Mango();
		m.sweet();
		m.yellow();
		
		Dog d = new Dog("Husky","Jack");
		d.show();
		
		

	}

}
