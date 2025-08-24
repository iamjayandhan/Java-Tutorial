public class Celebrity{

    public static void main(String[] args) {
        int mat[][] = { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 1 } };
        // int mat[][] = {{ 0 }};
        // int mat[][] = { {1, 1},{1, 1}};

        Celebrity celebrity = new Celebrity();
        System.out.println("Celebrity ID: " + celebrity.celebrity(mat));
    }

    // Method to find the celebrity
    public int celebrity(int mat[][]) {
        
        if(mat.length == 1 && mat[0].length == 1) return 0;

        int knowMe[] = new int[mat.length];
        int iKnow[] = new int[mat.length];

        for(int i=0; i<mat.length; i++) {
            int c = 0;
            for(int j=0; j<mat.length; j++) {
                if(i!=j && mat[i][j] == 1) {
                    knowMe[j]++;
                    c++;
                }
            }
            iKnow[i] = c;
        }

        for(int i=0; i<mat.length; i++) {
            if(knowMe[i] == mat.length-1 && iKnow[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}