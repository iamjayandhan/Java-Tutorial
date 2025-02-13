enum Laptop{
	//static final objects
	//cannot create new obj using new keyword
	//enum constructors are implicitly private, so cant instantiate them!
	Macbook(2000), XPS(2300), Surface(1500), ThinkPad; // one has no value! it req default constructor!

	//4 obj are there, so 3(parameterized constructor) + 1 default constructor will be called!

	private int price;

	private Laptop(){
		System.out.println("Default constructor: "+this.name());
		price = 500; // default price if not given!
	}

	private Laptop(int price){
		System.out.println("Parameterized constructor: "+this.name());
		this.price = price;
	}

	public static int getPrice(Laptop lap){
		return lap.price;
	}

	public static void setPrice(Laptop lap,int price){
		lap.price = price;
	}
}

public class EnumLaptop{
	public static void main(String args[]){
		// Laptop lap = Laptop.Macbook;
		// System.out.println(Laptop.getPrice(lap));

		Laptop lap2 = Laptop.Surface;
		System.out.println("Before: "+Laptop.getPrice(lap2));
		Laptop.setPrice(lap2, 999);
		System.out.println("After: "+Laptop.getPrice(lap2));


		System.out.println();
		//get all arrays
		for(Laptop l: Laptop.values()){
			System.out.println("Laptop: "+l+"\nprice: "+Laptop.getPrice(l));
		} 

	}
}