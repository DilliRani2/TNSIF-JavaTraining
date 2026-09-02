package packagesandaccessmodifiers.daytwo;

public class AMDemo {

	public static void main(String[] args) {
		AccessModifierDemo amd1 = new AccessModifierDemo();
		System.out.println(amd1.publicVar);
		//System.out.println(amd1.privateVar);
		System.out.println(amd1.protectedVar);
		System.out.println(amd1.defaultVar);

	}

}
