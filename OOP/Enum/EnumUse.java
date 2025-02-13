enum Status{
	//Named constants!
	Running, Failed, Pending, Success;
}

public class EnumUse{
	public static void main(String args[]){
		Status s = Status.Running;

		System.out.println(s);
		System.out.println(s.ordinal()); // index number of that!

		Status s2[] = Status.values();
		
		for(Status temp : s2){
			System.out.println(temp + " - " + temp.ordinal());

		}
	}	
}