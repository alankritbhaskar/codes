import java.util.*;

public class nQueens{

// nQueens Problem ==================================================================

    static int dir4[][] = {{0,-1},{-1,-1},{-1,0},{-1,1}};

    public static boolean isSafeToPlaceQueen(boolean[][] boxes, int r, int c) {
         
         for(int rad = 1;rad <= Math.max(boxes.length,boxes[0].length);rad++){

             // Since, we use combination method for finding nQueeen so we check in previous 4 dirn
             // as rest of the area ahead is already unexplored

             for(int d=0;d<dir4.length;d++){
                 int x= r + rad*dir4[d][0];
                 int y= c + rad*dir4[d][1];

                 if(x >= 0 && x < boxes.length &&  y >= 0 && y < boxes[0].length && boxes[x][y]==true){
                     return false;
                 }
             }
         }

         return true;
    }
    
    public static boolean row[];
    public static boolean col[];
    public static boolean diag[];
    public static boolean antiDiag[];

    public static void toggle(int r,int c,int m){
        row[r]= !row[r];
        col[c]= !col[c];
        diag[r-c+m-1]= !diag[r-c+m-1];
        antiDiag[r+c]= !antiDiag[r+c];
    }

// O(1) time
    public static boolean isSafeToPlaceQueen01(int r, int c,int m) {
         if(!row[r] && !col[c] && !diag[r-c+m-1] && !antiDiag[r+c])
         return true;
         return false;
    }


// tnq- total number of queens

    public static int nQueen01(boolean[][] boxes, int idx, int tnq, String ans) {
          if(tnq == 0){
              System.out.println(ans);
              return 1;
          }

          int count = 0;
          int n = boxes.length;
          int m = boxes[0].length;

          for(int i=idx;i<n*m;i++){
              int r= i/m;
              int c= i%m;

              if(isSafeToPlaceQueen01(r,c,m)){
                  toggle(r,c,m);
                  count += nQueen01(boxes,i+1,tnq-1,ans + "(" + r + "," + c + ") ");
                  toggle(r,c,m);
              }
          }

          return count;
    }


    public static void main(String[] args) {
        // System.out.println(queenCombination1D(5, 0, 3, 0, ""));
        // boolean[] tnb = new boolean[5];
        // System.out.println(queenPermutation1D(tnb, 3, 0, ""));

        int n = 4,m = 4;

        row = new boolean[n];
        col = new boolean[n];
        diag = new boolean[n+m+1];
        antiDiag = new boolean[n+m+1];

        boolean[][] tnb = new boolean[n][n];
        System.out.println(nQueen01(tnb, 0, n, ""));
        // System.out.println(queenPermutation2D(tnb, n, ""));
    }

}