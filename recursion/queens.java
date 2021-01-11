import java.util.*;
public class queens{

    public static int queenCombination1D(int tnq,int boxes,int qsf,int idx,String ans){
        if(qsf == tnq){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i=idx;i<boxes;i++){
        count+= queenCombination1D(tnq,boxes,qsf+1,i+1,ans+"b"+i+"q"+qsf+" ");
        }

        return count;
    }
    
    public static int queenPermutation1D(int tnq,boolean boxes[],int qsf,String ans){
        if(qsf == tnq){
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for(int i=0;i<boxes.length;i++){ // permutation hai to sare choices available ho jayenge not only those after index idx
        
        if(!boxes[i]){
        boxes[i]= true;// to ensure each queen is used once
        count+= queenPermutation1D(tnq,boxes,qsf+1,ans+"b"+i+"q"+qsf+" ");
        boxes[i]= false;
        }
         
        }

        return count;
    }

    public static int queenCombination2D(boolean boxes[][],int tnq,int qsf,int idx,String ans){
        if(qsf == tnq){
            System.out.println(ans);
            return 1;
        }

        int n=boxes.length;
        int m=boxes[0].length;
        int count=0;

        for(int i=idx;i<(n*m);i++){
            int r=idx/m; // 1d idx to 2d row
            int c=idx%m;// 1d idx to 2d col
            count+=queenCombination2D(boxes,tnq,qsf+1,i+1,ans+"("+r+","+c+") ");
        }

        return count;
    }

    public static int queenPermutation2D(boolean boxes[][],int tnq,int qsf,String ans){
        if(qsf == tnq){
            System.out.println(ans);
            return 1;
        }

        int n=boxes.length;
        int m=boxes[0].length;
        int count=0;

        for(int i=0;i<(n*m);i++){
            int r= i/m;
            int c= i%m;
            if(!boxes[r][c]){
             boxes[r][c]= true;
             count+=queenPermutation2D(boxes,tnq,qsf+1,ans+"("+r+","+c+") ");
             boxes[r][c]= false;
            }
        }

        return count;
    }


    public static void solve(){
        boolean boxes[][]=new boolean[4][4];
        int ans=queenPermutation2D(boxes,4,0,"");
        // int ans=queenCombination2D(boxes,4,0,0,"");
        System.out.println(ans);

       // set3();
    }

    public static void main(String args[]){
    solve();
    }
}