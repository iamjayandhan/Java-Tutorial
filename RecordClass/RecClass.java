import java.util.Objects;

// class Alien{
// 	private final int id;
// 	private final String name;

// 	public Alien(int id,String name){
// 		this.id = id;
// 		this.name = name;
// 	}

// 	public int getId(){
// 		return id;
// 	}

// 	public String getName(){
// 		return name;
// 	}

// 	@Override
// 	public String toString(){
// 		return "Alien{"
// 					+"id="+id+", name="+name+"}";
// 	}

// 	@Override
// 	public boolean equals(Object o){
// 		if(this == o) return true;
// 		if(o == null || getClass()!=o.getClass()) return false;
// 		Alien alien = (Alien)o;
// 		return id == alien.id && Objects.equals(name,alien.name);
// 	}

// 	@Override
// 	public int hashCode(){
// 		return Objects.hash(id,name);
// 	}
// }

//simple component class!
//All are private and final by default in record classes!
//You cannot modify them after object creation.
record Alien(int id,String name){

	//This constructor is optional! 
	// public Alien(int id, String name){
	// 	this.id = id;
	// 	this.name = name;
	// }

	static int num;

	public Alien{
		if(id == 0) throw new IllegalArgumentException("id cannot be zero");	
	}
}

public class RecClass{
	public static void main(String args[]){
		Alien a1 = new Alien(1, "JD");
		Alien a2 = new Alien(1, "JD");

		System.out.println(a1.equals(a2));
		System.out.println(a1 == a2);	
		
		//record class even has custom toString() func implemented!
		System.out.println(a1);
		System.out.println(a2);				
	}		
}