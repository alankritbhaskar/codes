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

// nQueen Permutation

    public static int nQueeen_Perm(boolean boxes[][],int tnq,String ans){
        if(tnq == 0){
            System.out.println(ans);
            return 1;
        }

        int count= 0;
        int n= boxes.length;

        for(int i=0;i<n*n;i++){
            int r= i/n;
            int c= i%n;

            if(!boxes[r][c] && isSafeToPlaceQueen01(r,c,n)){
            boxes[r][c]=true;
            toggle(r,c,n);
            count+=nQueeen_Perm(boxes,tnq-1,ans+"("+r+","+c+") ");
            toggle(r,c,n);
            boxes[r][c]=false;
        }
    }

    return count;
    }

// nQueen using the constraint that at least one queen must be placed in one row
// Optimization in recursive call

// Faith:- (n-1) queens apne aap ko (n-1) rows mein safely place krke aa jayengi then i will add myself in nth row

// floor- denotes a particular row or floor where one queen has to be placed
public static int nQueeen03(boolean boxes[][],int tnq,int floor,String ans){
    if(tnq == 0){
        System.out.println(ans);
        return 1;
    }

    int count= 0;
    int n= boxes.length;

    // c- any col of that given row
    for(int c=0;c<n;c++){
        if(isSafeToPlaceQueen01(floor,c,n)){
            toggle(floor,c,n);
            count+= nQueeen03(boxes,tnq-1,floor+1,ans+"("+floor+","+c+") ");
            toggle(floor,c,n);
        }
    }
    return count;
}

// Using Bit Manipulation to further optimize the space

// Concept in crux:-
// Any boolean array of size smaller than 64 elements can be represented by an binary number
// long for 64 bit 
// int for 32 bit
// This usage of a single number to replace a complete array reduces the complexity from O(n) to O(1)
// Therefore, the extra space used in this nQueens problem can be reduced by this method

static int rowBin;// no need of this variable as we place a single queen in each row so no nned to check fo other queens in
// a given row

static int colBin= 0;
static int diagBin= 0;
static int antiDiagBin= 0;

public static void toggleXOR(int r,int c,int n){
    colBin = (colBin^(1<<c));
    diagBin = (diagBin^(1<<(r-c+n-1)));
    antiDiagBin = (antiDiagBin^(1<<(r+c)));
}

public static boolean isSafeBinary(int r,int c,int n){
boolean colB= ((colBin & (1<<c))!=0)? false:true;
boolean diagB= ((diagBin & (1<<(r-c+n-1)))!=0)? false:true;
boolean antiDiagB= ((antiDiagBin & (1<<(r+c)))!=0)? false:true;

if(colB== true && diagB== true && antiDiagB== true)
return true;
return false;
}

public static int nQueenMostOpti(boolean boxes[][],int floor,int tnq,String ans){
    if(tnq == 0){
        System.out.println(ans);
        return 1;
    }

    int count= 0;
    int n= boxes.length;

    for(int c=0;c<n;c++){
        if(isSafeBinary(floor,c,n)){
            toggleXOR(floor,c,n);
            count+= nQueenMostOpti(boxes,floor+1,tnq-1,ans+"("+floor+","+c+") ");
            toggleXOR(floor,c,n);
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
        System.out.println(nQueenMostOpti(tnb,0,n,""));
        // System.out.println(queenPermutation2D(tnb, n, ""));
    }

}