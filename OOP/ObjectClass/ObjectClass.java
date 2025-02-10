//every class extends Object class by default
class Laptop{
	String model;
	int price;

	//override default behaviour of toString()
	public String toString(){
		return "WTF";
	}
}

public class ObjectClass{
	public static void main(String args[]){
		Laptop obj = new Laptop();
		obj.model = "Lenovo";
		obj.price = 1000;

		Laptop obj2 = new Laptop();
		obj2.model = "Lenovo";
		obj2.price = 1000;

		System.out.println(obj); // this is as same as
		System.out.println(obj.toString());

		System.out.println(obj.equals(obj2)); // checks memory references
		System.out.println(obj == obj2); // checks memory locations
	}
}