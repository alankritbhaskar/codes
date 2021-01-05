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

    
// https://practice.geeksforgeeks.org/problems/rat-maze-with-multiple-jumps/0#

    class GFG {
    
    public static Scanner sc=new Scanner(System.in);
    
    public static void display(int[][] vis) {
        for (int[] m : vis) {
            for (int ele : m)
                System.out.print(ele + " ");
            System.out.println();
        }
    }
    
    public static boolean floodFill(int sr, int sc, int dr, int dc, int[][] dir, 
    int[][] mat, int[][] vis) {
        
        if(sr==dr && sc==dc){
            vis[sr][sc]=1;
            display(vis);
            vis[sr][sc]=0;
            return true;
        }
        
        boolean res = false;
        vis[sr][sc] = 1;
        
        for(int rad = 1;rad <= mat[sr][sc];rad++){
            
            // har radius pe move krke check krenge ki whether we reached
            // a cell at shortest distance
            for(int d = 0;d < dir.length;d++){
                
                int x = sr + rad * dir[d][0];
                int y = sc + rad * dir[d][1];
                
                if (x >= 0 && y >= 0 && x <= dr && y <= dc)
                    res = res || floodFill(x,y,dr,dc,dir,mat,vis);
            }
        }
        
        vis[sr][sc] = 0;
        return res;
        }
    
	public static void main (String[] args) {
		int t=sc.nextInt();
		
		while(t-- > 0){
		    int n=sc.nextInt();
		    
		    int mat[][]=new int[n][n];
		    
		    for(int i=0;i<n;i++){
		        for(int j=0;j<n;j++){
		           mat[i][j]=sc.nextInt(); 
		        }
		    }
		    
		    boolean ans= false;
		    
	    	if (mat[0][0] != 0) {
                int[][] vis = new int[n][n];
                int[][] dir = { { 0, 1 }, { 1, 0 } };
                ans = floodFill(0, 0, n - 1, n - 1, dir, mat, vis);
            }
            if (!ans)
                System.out.println(-1);
        }
    }
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