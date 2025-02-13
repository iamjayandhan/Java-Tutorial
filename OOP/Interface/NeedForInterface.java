//fully class implementation!
//check NeedForInterface2.java for interface version of Computer!

//general class
class Computer{
	public void code(){
		System.out.println("[this will be overridden!]");
	}
}

//concrete class 
class Laptop extends Computer{
	public void code(){
		System.out.println("code, compile, run");
	}
}

//concrete class
class Desktop extends Computer{
	public void code(){
		System.out.println("code, compile, run : Faster");
	}
}

class Developer{
	public void devApp(Computer equipment){
		equipment.code();
	}
}

public class NeedForInterface{
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