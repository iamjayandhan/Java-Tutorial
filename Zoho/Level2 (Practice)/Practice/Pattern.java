public class Pattern {
    public static void main(String args[]){
        // 4 4 4 4 4 4 4 
        // 4 3 3 3 3 3 4 
        // 4 3 2 2 2 3 4 
        // 4 3 2 1 2 3 4 
        // 4 3 2 2 2 3 4 
        // 4 3 3 3 3 3 4 
        // 4 4 4 4 4 4 4 
        //for n = 4

        int n = 5;
        int len = (n * 2)-1;
        int mat[][] = new int[len][len];

        // for(int layer = 0; layer< n; layer++){
        //     int value = n - layer;
        //     for(int i = layer;i<len - layer;i++){
        //         for(int j = layer; j<len - layer;j++){
        //             mat[i][j] = value;
        //         }
        //     }
        // }

        //method2

        for(int i=0;i< len;i++){
            for(int j=0;j<len;j++){
                mat[i][j] = n - Math.min(Math.min(i,j),Math.min(len-i-1,len-j-1));
            }
        }

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
