import pkg1.A;
import pkg2.B;


//System lies here, we dont need to explicitly import this package.
//this is imported by default!
//import java.lang.*; // this is done by default

import java.lang.*; 
//* means all the files, not the folders!
//so it might throw error if we try to import all files from all folders in a main folder!


public class Pkg{
	public static void main(String args[]){
		A objA = new A();
		B objB = new B();
	}
}