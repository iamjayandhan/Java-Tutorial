//interface version of Computer!

//general class
 interface Computer{
	public void code();
}

//concrete class 
class Laptop implements Computer{
	public void code(){
		System.out.println("code, compile, run");
	}
}

//concrete class
class Desktop implements Computer{
	public void code(){
		System.out.println("code, compile, run : Faster");
	}
}

class Developer{
	public void devApp(Computer equipment){
		equipment.code();
	}
}

public class NeedForInterface2{
	public static void main(String args[]){
		Developer dev = new Developer();

		//what company wishes to provide
		Computer desktop = new Desktop();
		Computer lap = new Laptop();

		//give any one to dev
		dev.devApp(desktop);
		dev.devApp(lap);
	}
}