import java.util.ArrayList;

public class RecursionPermutation{
	static int count = 0;

	public static void main(String args[]){
		//permutations
		String str = "abc";
		// ArrayList<String> res = permutations2("",str);
		// System.out.println(res);

		// System.out.println(permutations3("",str));
		permutations4("",str);
		System.out.println(count);
	}

	//return number of permutations count!
	//count variable passed as parameter to function
	public static void permutations4(String included,String ques){
		if(ques.isEmpty()){
			count++;
			return;
		}

		char ch = ques.charAt(0);

		for(int i=0; i<=included.length();i++){
			String before = included.substring(0,i);
			String after = included.substring(i,included.length());
			permutations4(before+ch+after, ques.substring(1));
		}
		return;
	}

	//return number of permutations count!
	//count inside body
	public static int permutations3(String included,String ques){
		if(ques.isEmpty()){
			return 1;
		}

		char ch = ques.charAt(0);
		int count = 0;

		for(int i=0; i<=included.length();i++){
			String before = included.substring(0,i);
			String after = included.substring(i,included.length());
			count = count + permutations3(before+ch+after, ques.substring(1));
		}
		return count;
	}

	//return as arraylist
	public static ArrayList<String> permutations2(String included,String ques){
		if(ques.isEmpty()){
			// System.out.println(included);
			ArrayList<String> res = new ArrayList<>();
			res.add(included);
			return res;
		}

		char ch = ques.charAt(0);
		ArrayList<String> res = new ArrayList<>();

		for(int i=0; i<=included.length();i++){
			String before = included.substring(0,i);
			String after = included.substring(i,included.length());
			res.addAll(permutations2(before+ch+after, ques.substring(1)));
		}
		return res;
	}

	//simply print
	public static void permutations(String included,String ques){
		if(ques.isEmpty()){
			System.out.println(included);
			return;
		}

		char ch = ques.charAt(0);
		for(int i=0; i<=included.length();i++){
			String before = included.substring(0,i);
			String after = included.substring(i,included.length());
			permutations(before+ch+after, ques.substring(1));
		}
	}
}