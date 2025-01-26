package corejava;

interface Ab1{
	abstract void meth1();
}
interface Ab2{
	abstract void meth2();
	// INTERFACE CAN HAVE STATIC METHODS, SINCE STATIC METHOD CANNOT BE ABSTRACT WE NEED TO DEFINE THE BODY FOR IT
	public static void meth3() {
		System.out.println("meth 3");
	}
	//INTEFACE CANNOT CONTAIN NON-STATIC CONCRETE METHODS
//	public void meth4() {
//		System.out.println("meth 4");
//	}
}
class Im1forAb1 implements Ab1,Ab2{
	public void meth1() {
		System.out.println("This is meth1 method");
	}
	public void meth2() {
		System.out.println("This is meth2 method");
	}
}

/*
 * ABSTRACT class can be extended once
 * Inteface can be 
 */
public class AbstractClassMulti {
	public static void main(String[] args) {
		Im1forAb1 obj = new Im1forAb1();
		obj.meth1();
		obj.meth2();
		Ab2.meth3();
	}
}
