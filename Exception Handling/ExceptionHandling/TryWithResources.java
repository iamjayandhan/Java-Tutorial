import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.IOException;

public class TryWithResources{
	public static void main(String args[]) throws IOException{

		//it is not necessary to have catch when try is there
		//but necessary to have finally block! 
		int num = 0;
		BufferedReader bf = null;

		try{
			InputStreamReader in = new InputStreamReader(System.in);
			bf = new BufferedReader(in);
			num = Integer.parseInt(bf.readLine());
			System.out.println(num);
		}
		// catch(Exception e){
		// 	System.out.println("Something went wrong!");
		// }
		finally{ //got exception or not, this block will always be executed!
			//finally is usually used to closed resources!
			// System.out.println("Bye...");
			bf.close();
		}

		//OPTIMIZED CODE
		//JAVA has try-with-resources syntax!
		try(Scanner sc = new Scanner(System.in)){  //open resources in try(), it will be closed automatically!
			//Scanner implements Closable Interface, that extends AutoCloseable! 
			//This resources can be closed automatically!

			int num2 = sc.nextInt();
			System.out.println(num2);
		}
	}
}