public class RecursionString{
	public static void main(String args[]){
		String question = "baccad";
		// StringBuilder result = skipAChar(question,'c');
		// System.out.println(result.toString());

		// String res = "";
		// System.out.println(skipAChar2(res,question,'a'));

		String question2 = "badapplefg";
		String res = "";
		System.out.println(skipAString(question2,res,"apple"));
		System.out.println(skipAStringWhenNot(question2,res,"apple"));
	}

	public static String skipAStringWhenNot(String ques, String res, String skip){
		if(ques.isEmpty()){
			return "";
			// return res;
		}

		if(ques.startsWith("app") && !ques.startsWith(ques)){
			return skipAStringWhenNot(ques.substring(skip.length()),res,skip);
		}
		else{
			// return skipAString(ques.substring(1),res+ques.charAt(0),skip) //or
			return ques.charAt(0) + skipAStringWhenNot(ques.substring(1),res,skip);
		}
	}

	public static String skipAString(String ques, String res, String skip){
		if(ques.isEmpty()){
			return "";
			// return res;
		}

		if(ques.startsWith(skip)){
			return skipAString(ques.substring(skip.length()),res,skip);
		}
		else{
			// return skipAString(ques.substring(1),res+ques.charAt(0),skip) //or
			return ques.charAt(0) + skipAString(ques.substring(1),res,skip);
		}
	}


	//using char from body;
	public static String skipAChar2(String res, String ques,char skip){
		if(ques.isEmpty()){
			return "";//or
			//return res;
		}

		char ch = ques.charAt(0);
		if(ch == skip){
			return skipAChar2(res,ques.substring(1),skip); //only "" passed
		}
		else{
			//ch is only passed
			return ch+skipAChar2(res,ques.substring(1),skip);// or
			//return skipAChar2(res+ch,ques.substring(1),skip);
		}
	}

	//using stringbuilder in parameter
	public static StringBuilder skipAChar(String str,char chr){
		StringBuilder res = new StringBuilder();
		return skipACharHelper(str,res,0,chr);
	}

	public static StringBuilder skipACharHelper(String str, StringBuilder res, int ind, char chr){
		if(ind == str.length()){
			return res;
		}

		if(str.charAt(ind) != chr){
			res.append(str.charAt(ind));
		}
		return skipACharHelper(str,res,ind+1,chr);
	}


}