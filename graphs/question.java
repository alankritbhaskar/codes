import java.util.*;

public class Questions{

    // Leetcode 200-- Number of Islands
    class Solution {
    public int numIslands(char[][] grid) {
        int c=0;
        int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    numIslandsDFS(grid,i,j,dir);
                    c++;
                }
            }
        }
        return c;
    }
    
    public static void numIslandsDFS(char[][] grid,int r,int c,int dir[][])
    {
        grid[r][c]='0';
        for(int d=0;d<dir.length;d++){
            int x=r+dir[d][0];
            int y=c+dir[d][1];
            
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]=='1'){
                numIslandsDFS(grid,x,y,dir);
            }
        }
    }    
    }

    // Leetcode 695-- Max. area of Islands

    class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int mx_area=0;
        
        int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int curr=maxAreaIslandDFS(grid,i,j,dir);
                    mx_area=Math.max(mx_area,curr);
                }
            }
        }
        return mx_area;
    }
    public static int maxAreaIslandDFS(int grid[][],int r,int c,int dir[][]){
    
        grid[r][c]=0;
        int count=0;
        for(int d=0;d<dir.length;d++){
            int x=r+dir[d][0];
            int y=c+dir[d][1];
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1)
            count+=maxAreaIslandDFS(grid,x,y,dir);
        }
      
        return count+1;
    }
}

// Leetcode 463-- Islands perimeter

class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int dir[][]={{1,0},{0,-1},{-1,0},{0,1}};
        int ones=0,nbrs=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ones++;
                    for(int d=0;d<4;d++){
                        int x=i+dir[d][0];
                        int y=j+dir[d][1];
                        
                       if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1)                     
                          nbrs++;
                    }
                }
            }
        }
        
        int t=4*ones-nbrs;
        return t;
    }
}

// Leetcode 130-- Surrounded Regions

class Solution {
    public void solve(char[][] board) {
        int dir[][]={{1,0},{0,-1},{-1,0},{0,1}};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0 || i==board.length-1 || j==0 || j== board[0].length-1){
                    if(board[i][j]=='O')
                    surroundedDFS(board,i,j,dir);
                }
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void surroundedDFS(char board[][],int r,int c,int dir[][]){
    
        board[r][c]='#';
        for(int d=0;d<4;d++){
            int x=r+dir[d][0];
            int y=c+dir[d][1];
            
            
            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]=='O'){
                surroundedDFS(board,x,y,dir);
            }
        }
    }
}

}