public class Performance {
    public static void main(String[] args) {
        String series = "";
        //inefficient code - new objects are created ever iteration!
        for(int i=0;i<26;i++){
            series += (char)('a'+i);
        }
        System.out.println(series);
    }
}
