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


  
  int main(){ 

  return 0;
  }
