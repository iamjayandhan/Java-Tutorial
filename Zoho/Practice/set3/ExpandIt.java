// Eg 1: Input: a1b10
//        Output: abbbbbbbbbb
// Eg: 2: Input: b3c6d15
//           Output: bbbccccccddddddddddddddd
// The number varies from 1 to 99.

// note: https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
// a - 97, z - 122
// A - 65, Z - 90

public class ExpandIt{
       public static void main(String args[]){
              String inp = "a1b10";

              StringBuilder sb = new StringBuilder();

              int i=0;
              while(i<inp.length()){
                     StringBuilder chars = new StringBuilder();
                     StringBuilder ints = new StringBuilder();

                     while(!(inp.charAt(i) <= 57) && !(inp.charAt(i)>=48)) chars.append(inp.charAt(i++));
                     while(inp.charAt(i) <= 57 && inp.charAt(i)>=48) ints.append(inp.charAt(i++));

                     // int in = Integer.parseInt(new String(ints));
                     System.out.println(new String(ints));
                     // while (in!=0){
                     //        sb.append(chars);
                     //        in--;
                     // }
              }

              System.out.println(sb);
       }
}