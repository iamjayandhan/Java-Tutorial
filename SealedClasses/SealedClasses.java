sealed class A extends Object implements Cloneable permits B,C{ // first extends, implements,then last is permits!
	//code here
}

final class B extends A{
	//comm'n
}

sealed class C extends A permits D{
	//yeah... 
}

// class Lorry extends Vehicle{ // error! not permitted by Vehicle class
// }

final class D extends C{
	//works!
}

//also works with interface
sealed interface X permits Y{

}

sealed interface Y extends X permits Z {

} // ✅ Y now permits Z

final class Z implements Y { 

}


public class SealedClasses{
	public static void main(String args[]){

	}	
}