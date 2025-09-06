public class LongestWord {
    public static void main(String args[]){
        String str = "I love programming in Python";
        printLongestWord(str);
    }

    public static void printLongestWord(String str){
        String words[] = str.split(" ");
        int maxSize = 0;
        String lw = "";

        for(String s: words){
            if(s.length() > maxSize) {
                maxSize = s.length();
                lw = s;
            }
        }
        System.out.println("Largest word is: "+ lw);
    }
}
