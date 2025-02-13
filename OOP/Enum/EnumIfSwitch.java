enum Status{
	//Named constants!
	Running, Failed, Pending, Success;
}

public class EnumIfSwitch{
	public static void main(String args[]){
		Status s = Status.Running;

		//if else
		if(s == Status.Running){
			System.out.println("All Good");
		}
		else if(s == Status.Failed){
			System.out.println("Try Again");
		}
		else if(s == Status.Pending){
			System.out.println("Please Wait");
		}
		else{
			System.out.println("Done");
		}
		
		//switch
		switch(s) // switch automatically knows its value type and we can directly use constants!
		{
			case Running:
				System.out.println("All Good");
				break;
			case Failed:
				System.out.println("Try Again");
				break;
			case Pending:
				System.out.println("Please Wait");
				break;
			default:
				System.out.println("Done");
				break;
		}
	}	
}