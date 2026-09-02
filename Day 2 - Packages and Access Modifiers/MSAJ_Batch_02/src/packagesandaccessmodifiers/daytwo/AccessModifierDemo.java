package packagesandaccessmodifiers.daytwo;

public class AccessModifierDemo {
	
	public int publicVar = 10;
	private int privateVar = 20; //instance variable
	 
	protected int protectedVar = 30;
	int defaultVar = 40;

	public static void main(String[] args) {
		
		AccessModifierDemo amd = new AccessModifierDemo();
		System.out.println(amd.publicVar);
		System.out.println(amd.privateVar);
		System.out.println(amd.protectedVar);
		System.out.println(amd.defaultVar);
		
		
		
		
	}
	
	

}
