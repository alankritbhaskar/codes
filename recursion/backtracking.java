import java.util.*;

public class backtracking{

// Matrix move 8 direction variation

    public static int floodfill1(int sr,int sc,int er,int ec,boolean vis[][],String print[],int dir[][],String path){

        if(sr==er && sc==ec){
            System.out.println(path);
            return 1;
        }

        int count=0;
        vis[sr][sc]=true;
        
        for(int d=0;d<dir.length;d++){
            int x=sr+dir[d][0];
            int y=sc+dir[d][1];

            if(x>=sr && x<=er && y>=sc && y<=ec && vis[x][y]==false)
            count+=floodfill1(x,y,er,ec,vis,print,dir,path+print[d]);
        }

        vis[sr][sc]=false;
        return count;
    }


    public static void set1(){
    int n=4,m=4;

    int dir[][]={{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1}};
    String print[]={"R","S","D","W","L","N","U","E"};

    boolean vis[][]=new boolean[n][m];
    System.out.println(floodfill1(0,0,n-1,m-1,vis,print,dir,""));

    return;
    }

    public static void solve(){
        set1();
       // set3();
    }

    public static void main(String args[]){
    solve();
    }

}