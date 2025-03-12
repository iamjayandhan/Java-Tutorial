import java.util.*;

class TechnexTickets
{
	public static void main (String[] args) throws java.lang.Exception
	{
		ArrayList<Integer> queue = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));

        //op: 1,2,1,3,2
	    
	    //record the order!
        int order[] = new int[queue.size()];

        int turnNumber = 1;
        boolean flag = false;

        while (!queue.isEmpty()){
            if(!flag){
                queue.remove(0);
                order[0] = turnNumber;
            }
            else{
                queue.remove(1);
                order[1] = turnNumber;
                turnNumber++;
            }
            flag = !flag;
        }
        
        System.out.println(Arrays.toString(order));
	}
}
