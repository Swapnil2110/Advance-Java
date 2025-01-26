package corejava;

abstract class AbstractClassP{
	abstract void method1();
}

class AbstractClassC extends AbstractClassP{
	void method1() {
		System.out.println("abstract method 1");
	}
}

class ImpClassForAbstractClassC extends AbstractClassC{
	void callingmethod() {
		AbstractClassC obj = new AbstractClassC();
		obj.method1();
	}
}

class AbstractClassC2 extends AbstractClassP{
	void method1() {
		System.out.println("abstract method 2");
	}
}

public class AbstractClassTest{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractClassC obj = new AbstractClassC();
		AbstractClassC2 obj2 = new AbstractClassC2();
		obj.method1();
		obj2.method1();
		ImpClassForAbstractClassC ob3 = new ImpClassForAbstractClassC();
		ob3.callingmethod();
	}
	

}
