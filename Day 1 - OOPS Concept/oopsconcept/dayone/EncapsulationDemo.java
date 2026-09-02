package oopsconcept.dayone;

public class EncapsulationDemo {
	
	//CSK Team
	
	private String name; //Null
	private int age; //0
	private int jersyNo;//0
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}





	public void setAge(int age) {
		this.age = age;
	}





	public int getJersyNo() {
		return jersyNo;
	}





	public void setJersyNo(int jersyNo) {
		this.jersyNo = jersyNo;
	}


	@Override
	public String toString() {
		return "EncapsulationDemo [name=" + name + ", age=" + age + ", jersyNo=" + jersyNo + "]";
	}

	


}
