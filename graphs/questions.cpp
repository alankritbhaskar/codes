  #include<algorithm>
  #include<iostream>
  #include<vector>

  using namespace std;

// Leetcode 200- Number of Islands

    void numIslandsDFS(int sr,int sc,vector<vector<char>>& grid,vector<vector<int>> &dir){
    
    grid[sr][sc]= '0';
    for(int d=0;d<dir.size();d++){
        int x=sr+dir[d][0];
        int y=sc+dir[d][1];

        if(x>=0 && x<grid.size() && y>=0 && y<grid[0].size() && grid[x][y]=='1')
        numIslandsDFS(x,y,grid,dir);
    }   
    }
    
    int numIslands(vector<vector<char>>& grid) {
        if(grid.size()==0 && grid[0].size()==0)
        return 0;

        int n=grid.size();
        int m=grid[0].size();

        vector<vector<int>> dir{
          {0,1},{0,-1},{1,0},{-1,0}  
        };

        int countOfIslands=0;

        //Call for dfs from each cell of the grid
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            if(grid[i][j]=='1')
            {
                numIslandsDFS(i,j,grid,dir);
                countOfIslands++;
            }
            }
        }
        return countOfIslands;
    }  

// Leetcode 695. Max Area Island

        int areaIslandsDFS(int sr,int sc,vector<vector<int>>& grid,vector<vector<int>> &dir){
    
    grid[sr][sc]= 0;
    int area= 0;
    for(int d=0;d<dir.size();d++){
        int x=sr+dir[d][0];
        int y=sc+dir[d][1];

        if(x>=0 && x<grid.size() && y>=0 && y<grid[0].size() && grid[x][y]== 1)
        area+= areaIslandsDFS(x,y,grid,dir);
    }
            return area+1;//sare nbrs se max area manga liya uske baad khud ka 1 area usme sum kr diya
    }
      
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        if(grid.size()==0 && grid[0].size()==0)
        return 0;

        int n=grid.size();
        int m=grid[0].size();

        vector<vector<int>> dir{
          {0,1},{0,-1},{1,0},{-1,0}  
        };

        int maxArea=0;

        //Call for dfs from each cell of the grid
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            if(grid[i][j]==1)
             maxArea=max(maxArea,areaIslandsDFS(i,j,grid,dir));
            }
        }
        return maxArea;  
    }

// Leetcode 463. Island Perimeter

// 1- island
// 0- water
// Strategy:- Pata karlo ki total kitne islands hai aur total sare islands ke kitne neighbour islands hai
    
// Formula:- Total perimeter= islands*4-nbrs
    
    int islandPerimeter(vector<vector<int>>& grid) {
    
        vector<vector<int>> dir{
            {1,0},{0,-1},{-1,0},{0,1}  
        };
        
        int islands = 0;
        int nbrs = 0;
        
        for(int i=0; i<grid.size(); i++){
            for(int j = 0;j < grid[0].size(); j++){
                if(grid[i][j]==1){
                    islands++;
                    
                    for(int d=0;d<dir.size();d++){
                        int x=i+dir[d][0];
                        int y=j+dir[d][1];
                        
                        if(x>=0 && x<grid.size() && y>=0 && y<grid[0].size() && grid[x][y]==1)
                            nbrs++; //valid nbrs for each island 
                    }
                }
            }
        }
        
        int totalPerimeter=4*islands-nbrs;
        return totalPerimeter;
    }

// Leetcode 130. Surrounded Regions

    void surroundDFS(int sr,int sc,vector<vector<char>> &grid,vector<vector<int>> &dir){
        
        grid[sr][sc]='#';
        for(int d=0;d<dir.size();d++){
            int x=sr+dir[d][0];
            int y=sc+dir[d][1];
            
            
            if(x>=0 && y>=0 && x<grid.size() && y<grid[0].size() && grid[x][y]=='O'){
                surroundDFS(x,y,grid,dir);
            }
        }
    }
    
    void solve(vector<vector<char>>& grid) {
    
        if(grid.size()==0 || grid[0].size()==0)
        return;
        
        vector<vector<int>> dir{
            {1,0},{0,-1},{-1,0},{0,1}  
        };

        // DFS from boundary to mark all the 'O' as '#'
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[0].size();j++){
            
            if((i==0 || i==grid.size()-1 || j==0 || j==grid[0].size()-1) && grid[i][j]=='O'){
                        surroundDFS(i,j,grid,dir);
            }
            }
            }
        
        // Mark all '#' as 'O' as they have been marked from boundary, and all left 'O' as 'X'
        // as they are surrounded so could not be reached using dfs from boundary
        
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[0].size();j++){
                if(grid[i][j]=='O')
                    grid[i][j]='X';
                else if(grid[i][j]=='#')
                    grid[i][j]='O';
            }
        } 
    }



  
  int main(){ 

  return 0;
  }
