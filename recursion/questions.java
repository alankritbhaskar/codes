import java.util.*;

public class questions{


    public static int wordBreak(String str,String ans,HashSet<String> dict,int maxWordLength) {
    
    if(str.length() == 0){
        System.out.println(ans);
        return 1;
    }
    
    int count = 0;
    
    // ros- rest of string
    for(int len=1;len<=Math.min(maxWordLength,str.length());len++){
        String word = str.substring(0,len);
        String ros = str.substring(len);
        
        if(dict.contains(word)){
            count += wordBreak(ros,ans+word+" ",dict,maxWordLength);
        }
    }
    
    return count;
    }

    public static void wordBreakUtil(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashSet < String > dict = new HashSet < > ();
        for (int i = 0; i < n; i++) {
            dict.add(scn.next());
        }
        
        int maxWordLength = 0;
        
        for(String word: dict)
        maxWordLength = Math.max(maxWordLength,word.length());
        
        String sentence = scn.next();
        wordBreak(sentence, "", dict,maxWordLength);
    }


// Knights Tour

    public static void display(int arr[][]){
        for(int ar[]: arr){
            for(int ele: ar)
            System.out.print(ele+" ");
            System.out.println();
        }
    }

    static int dir[][] = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};

    public static int knightsTour(int board[][],int currMove,int r,int c){
        int n = board.length;
        if(currMove == n*n){
            board[r][c] = currMove;
            display(board);
            System.out.println();
            return 1;
            //board[r][c] = 0;
        }

        int count = 0;

        for(int d=0;d<dir.length;d++){
            int x = r+dir[d][0];
            int y = c+dir[d][1];

            if(x>=0 && x<n && y>=0 && y<n && board[x][y]==0){
                board[x][y] = currMove;
                count += knightsTour(board,currMove+1,x,y);
                board[x][y] = 0;
            }
        }
        return count;

    }

    public static void main(String[] args) {

        int n = 5;
        int board[][] = new int[n][n]; 

        System.out.println(knightsTour(board,1,2,0));
    }

}