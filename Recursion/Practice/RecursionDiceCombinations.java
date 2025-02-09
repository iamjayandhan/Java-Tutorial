import java.util.ArrayList;

public class RecursionDiceCombinations{
	public static void main(String args[]){
		// diceCombinations("",4);
		ArrayList<String> res = diceCombinationsList("",6);
		System.out.println(res);
	}

	//not a six faced die?
	public static ArrayList<String> diceCombinationsFaceList(String processed, int target,int face){
		if(target <= 0){
			ArrayList<String> res = new ArrayList<>();
			if(target == 0){
				res.add(processed);
			}
			return res;
		}

		ArrayList<String> res = new ArrayList<>();
		for(int i=1;i<=face;i++){
			res.addAll(diceCombinationsFaceList(processed+i,target-i,face));
		}
		return res;
	}

	//aslist?
	public static ArrayList<String> diceCombinationsList(String processed, int target){
		if(target <= 0){
			ArrayList<String> res = new ArrayList<>();
			if(target == 0){
				res.add(processed);
			}
			return res;
		}

		ArrayList<String> res = new ArrayList<>();
		for(int i=1;i<=6;i++){
			res.addAll(diceCombinationsList(processed+i,target-i));
		}
		return res;
	}

	//print the possibilities!
	public static void diceCombinations(String processed, int target){
		if(target <= 0){
			if(target == 0) System.out.println(processed);
			return;
		}

		for(int i=1;i<=6;i++){
			diceCombinations(processed+i,target-i);
		}
		return;
	}
}