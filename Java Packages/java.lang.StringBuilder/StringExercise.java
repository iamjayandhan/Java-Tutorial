public class StringExercise{
    public static void main(String[] args) {
        // int a = 10; // primitive, stores in stack
        // int b[] = {1,2,3,4,5}; // primitive, b in stack & values in heap.

        String a = "iamjayandhan";
        String b = "iamjayandhan";

        //String comparisons
        //1. == (checks ref var)
        // System.out.println(a == b); //true (both ref vars points to same obj)
        
        //create diff objs of same value?
        String c = new String("JD");
        String d = new String("JD");
        //both works because this creates obj outside the string pool
        // System.out.println(c == d); //false (both obj are diff, though they has same val)
    

        // .equals() (checks only value)
        System.out.println(a==b); //true
        System.out.println(a.equals(b)); //true

        System.out.println(c==d); //false
        System.out.println(c.equals(d)); //false
    }
}