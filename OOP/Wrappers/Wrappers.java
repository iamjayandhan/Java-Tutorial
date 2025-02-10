public class Wrappers{
	public static void main(String args[]){
		int num = 8;
		Integer num1 = num; //auto boxing

		int num2 = num1;

		System.out.println(num2);

		String str = "12";
		int num3 = Integer.parseInt(str);
		System.out.println(num3);
	}
}