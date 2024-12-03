
/*
 * Time complexity of code?
 * 
*/

public class TimeComplexityExample{
    public static void main(String args[]){

        //Linear relationship with n
        //O(n)
        int n = 1;
        for(int i=0;i<n;i++){
            System.out.println(i);
        }

        //O(n*n)
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.println(j);
            }
        }

        //factorial
        //O(n)
        int fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }


        int m=100;
        int l = 20;
        
        //O(m+n) <= O(m) + O(n)
        for(int i=0;i<m;i++){
            System.out.println();
        }
        for(int i=0;i<l;i++){
            System.out.println();
        }

        //O(m*n)
        for(int i=0;i<m;i++){
            for(int j=0;j<l;j++){
                System.out.println();
            }
        }
       
    }
}
