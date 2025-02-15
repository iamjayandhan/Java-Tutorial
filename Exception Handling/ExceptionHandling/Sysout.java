import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sysout{
	public static void main(String args[]) throws IOException{

		// To use println, we need to create obj of PrintStream class!
		// 'out' here is actually an obj of PrintStream class! 
		// 'out' is declared inside System class!
		// SO WE WRITE System.out.println();
		
		//get input from user!
		System.out.println("Enter a number: ");
		// To take input, we need to create obj of InputStream class!
		// 'in' is obj of InputStream
		// 'in' is declared static in System class!
		// SO WE WRITE System.in.read();

		//method1
		// int num = System.in.read(); // returns ascii value of entered number! (only one CHARACTER! NO BIG STUFF)
		// System.out.println(num);

		//method2
		// InputStreamReader in = new InputStreamReader(System.in);
		// BufferedReader bf = new BufferedReader(in);

		//BufferedReader can take input from keyboard, file, network!
		//it is our responsibility to close the opened resource!
		//check line33!

		// int num2 = Integer.parseInt(bf.readLine()); // string to integer!
		// System.out.println(num2);

		//bf.close();

		//method3
		Scanner sc = new Scanner(System.in);
		int num3 = sc.nextInt();

		System.out.println(num3);
		sc.close();
	}
}