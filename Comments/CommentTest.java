public class CommentTest{

    //single line comment
    /*
        *Multi-line 
        * comment
    */

    /**
     * This method is to add two numbers
    */
    public static int add(int a , int b){
        return a+b;
    }

    public static void main(String args[]){
        System.out.println(CommentTest.add(10,20));
    }
}