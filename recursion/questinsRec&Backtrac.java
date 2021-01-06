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

// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#

    static ArrayList<String> ans;
    
    public static void floodFill(int sr,int sc,int er,int ec,int mat[][],String psf,
    int dir[][],String dirS[]){
        
        if(sr==er && sc==ec){
           ans.add(psf);
           return;
        }
        
        mat[sr][sc]=0;
        for(int d=0;d<dir.length;d++){
            int x=sr+dir[d][0];
            int y=sc+dir[d][1];
            
            if(x>=0 && x<mat.length && y>=0 && y<mat[0].length && mat[x][y]==1)
            floodFill(x,y,er,ec,mat,psf+dirS[d]+"",dir,dirS);
        }
        mat[sr][sc]=1;
        
    }
        
    public static ArrayList<String> findPath(int[][] m, int n) {
        ans= new ArrayList<>();
        
        if(n==0 || m[0][0]==0 || m[n-1][n-1]==0)
        return ans;
        
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        String dirS[]={"U","D","L","R"};
        
        floodFill(0,0,n-1,n-1,m,"",dir,dirS);
        Collections.sort(ans);
        
        return ans;
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

// Count no. of ways to reach destination in a maze
// https://practice.geeksforgeeks.org/problems/special-matrix/0#

class GFG {
    
    static int M=(int)1e9 + 7;
    static Scanner sc=new Scanner(System.in);
    
    public static int floodFill(int sr,int sc,int er,int ec,int mat[][]){
       if(sr==er && sc==ec)
       {
           return 1;
       }
       
       int count=0;
       
       if(sr+1 <= er && sc<=ec && mat[sr+1][sc]==0)
       count = (count % M + floodFill(sr+1,sc,er,ec,mat) % M) % M;
       
       if(sc+1 <= ec && sr<=er && mat[sr][sc+1]==0)
       count = (count % M + floodFill(sr,sc+1,er,ec,mat) % M) % M;
       
       return count;    
    }
    
    public static int floodFillDP(int sr,int sc,int er,int ec,int mat[][],int dp[][]){
       if(sr==er && sc==ec)
       {
           return dp[sr][sc]=1;
       }
       
       if(dp[sr][sc] != -1)
       return dp[sr][sc];
       
       int count=0;
       
       if(sr+1 <= er && sc<=ec && mat[sr+1][sc]==0)
       count = (count % M + floodFillDP(sr+1,sc,er,ec,mat,dp) % M) % M;
       
       if(sc+1 <= ec && sr<=er && mat[sr][sc+1]==0)
       count = (count % M + floodFillDP(sr,sc+1,er,ec,mat,dp) % M) % M;
       
       return dp[sr][sc]=count;    
    }
    
	public static void main (String[] args) {
	int t = sc.nextInt();
	
	while(t-- > 0){
	
	int n = sc.nextInt();
	int m = sc.nextInt();
	int k = sc.nextInt();
	
	//  0-free , 1-blocked
	
	int mat[][]=new int [n][m];
	int dp[][]=new int[n][m];
	
	for(int d[]: dp)
	Arrays.fill(d,-1);

    for(int i=0;i<k;i++){
        int x=sc.nextInt();
        int y=sc.nextInt();
        //System.out.println(x+"."+y+",");
        mat[x-1][y-1]=1;// blocking the elements of my matrix
    }
    
    int count = floodFillDP(0,0,n-1,m-1,mat,dp);
	System.out.println(count);
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