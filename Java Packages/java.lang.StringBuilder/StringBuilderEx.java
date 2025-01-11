public class StringBuilderEx {
    public static void main(String[] args) {
        StringBuilder series2 = new StringBuilder(); //Obj
        for(int i=0;i<26;i++){
            series2.append((char)('a'+i)); //changes are made on one obj only. New are not created everytime!
        }
        System.out.println(series2);
    }
}
