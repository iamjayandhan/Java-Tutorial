public class CountValley {
    //https://www.hackerrank.com/challenges/counting-valleys/problem
    public static void main(String args[]){
        int seaLevel = 0;
        int valleyCount = 0;

        String s = "UDDDUDUU";

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'U'){
                seaLevel++;
                if(seaLevel ==0) valleyCount++;
            }else{
                seaLevel--;
            }
        }
        System.out.println(valleyCount);
    }
}
