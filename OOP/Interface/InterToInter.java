// class - class => extends
// class - interface => implements
// interface - interface => extends

interface X{
	void showX();
}

interface Y extends X{
	void showY();
}

class Z implements Y{
	public void showY(){
		System.out.println("Inside showY");
	}
	public void showX(){
		System.out.println("Inside showX");
	}
}

public class InterToInter{
	public static void main(String args[]){
		Z objZ = new Z();
		objZ.showY();
		objZ.showX();


		X objX = new Z();
		ibjX.showX(); // works!
		objX.showY(); //fails?
	}
}