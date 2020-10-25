#include <iostream>
#include <vector>

using namespace std;

void print(vector<int> &arr)
{
    for (int ele : arr)
    {
        cout << ele << " ";
    }
    cout << endl;
}

void print2D(vector<vector<int>> &arr)
{
    for (vector<int> ar : arr)
    {
        print(ar);
    }
    cout << endl;
}

//Two Pointer Type.========================================================

// Leetcode-509: Fibbonacci Number

int fib01(int n, vector<int> &dp)
{
    if (n <= 1)
        return dp[n] = n;

    if (dp[n] != 0)
        return dp[n];

    int a = fib01(n - 1, dp);
    int b = fib01(n - 2, dp);

    return dp[n] = a + b;
}

int fib01_DP(int N, vector<int> &dp)
{
    for (int n = 0; n <= N; n++)
    {
        if (n <= 1)
        {
            dp[n] = n;
            continue;
        }

        int a = dp[n - 1]; //fib01(n - 1, dp);
        int b = dp[n - 2]; //fib01(n - 2, dp);

        dp[n] = a + b;
    }

    return dp[N];
}

int fib01_opti(int N)
{
    int a = 0, b = 1;
    for (int n = 2; n <= N; n++)
    {
        int sum = a + b;
        a = b;
        b = sum;
    }

    return b;
}

void fibo()
{
    int n = 7;
    vector<int> dp(n + 1, 0);
    // cout << fib01(n, dp) << endl;
    cout << fib01_DP(n, dp) << endl;
    cout << fib01_opti(n) << endl;

    print(dp);
}

int mazePath(int sr, int sc, int er, int ec, vector<vector<int>> &dp)
{
    if (sr == er && sc == ec)
    {
        return dp[sr][sc] = 1;
    }

    if (dp[sr][sc] != 0)
        return dp[sr][sc];

    int count = 0;
    if (sr + 1 <= er)
        count += mazePath(sr + 1, sc, er, ec, dp);
    if (sc + 1 <= ec)
        count += mazePath(sr, sc + 1, er, ec, dp);
    if (sr + 1 <= er && sc + 1 <= ec)
        count += mazePath(sr + 1, sc + 1, er, ec, dp);

    return dp[sr][sc] = count;
}

int mazePathDP(int SR, int SC, int er, int ec, vector<vector<int>> &dp)
{
    for (int sr = er; sr >= 0; sr--)
    {
        for (int sc = ec; sc >= 0; sc--)
        {

            if (sr == er && sc == ec)
            {
                dp[sr][sc] = 1;
                continue;
            }

            int count = 0;
            if (sr + 1 <= er)
                count += dp[sr + 1][sc]; //mazePath(sr + 1, sc, er, ec, dp);
            if (sc + 1 <= ec)
                count += dp[sr][sc + 1]; //mazePath(sr, sc + 1, er, ec, dp);
            if (sr + 1 <= er && sc + 1 <= ec)
                count += dp[sr + 1][sc + 1]; //mazePath(sr + 1, sc + 1, er, ec, dp);

            dp[sr][sc] = count;
        }
    }

    return dp[SR][SC];
}

int mazePath_Multiple(int sr, int sc, int er, int ec, vector<vector<int>> &dp)
{
    if (sr == er && sc == ec)
    {
        return dp[sr][sc] = 1;
    }

    if (dp[sr][sc] != 0)
        return dp[sr][sc];

    int count = 0;
    for (int jump = 1; sr + jump <= er; jump++)
        count += mazePath_Multiple(sr + jump, sc, er, ec, dp);
    for (int jump = 1; sc + jump <= ec; jump++)
        count += mazePath_Multiple(sr, sc + jump, er, ec, dp);
    for (int jump = 1; sr + jump <= er && sc + jump <= ec; jump++)
        count += mazePath_Multiple(sr + jump, sc + jump, er, ec, dp);

    return dp[sr][sc] = count;
}

int mazePath_MultipleDP(int SR, int SC, int er, int ec, vector<vector<int>> &dp)
{
    for (int sr = er; sr >= 0; sr--)
    {
        for (int sc = ec; sc >= 0; sc--)
        {

            if (sr == er && sc == ec)
            {
                dp[sr][sc] = 1;
                continue;
            }

            int count = 0;
            for (int jump = 1; sr + jump <= er; jump++)
                count += dp[sr + jump][sc]; //mazePath_Multiple(sr + jump, sc, er, ec, dp);
            for (int jump = 1; sc + jump <= ec; jump++)
                count += dp[sr][sc + jump]; //mazePath_Multiple(sr, sc + jump, er, ec, dp);
            for (int jump = 1; sr + jump <= er && sc + jump <= ec; jump++)
                count += dp[sr + jump][sc + jump]; //mazePath_Multiple(sr + jump, sc + jump, er, ec, dp);

            dp[sr][sc] = count;
        }
    }

    return dp[SR][SC];
}

void mazePath()
{
    int n = 4;
    int m = 4;
    vector<vector<int>> dp(n, vector<int>(m, 0)); // int[][] dp = new int[n][m];
    // cout << mazePath(0, 0, n - 1, m - 1, dp) << endl;
    // cout << mazePathDP(0, 0, n - 1, m - 1, dp) << endl;

    // cout << mazePath_Multiple(0, 0, n - 1, m - 1, dp) << endl;
    cout << mazePath_MultipleDP(0, 0, n - 1, m - 1, dp) << endl;

    print2D(dp);
}

        // Leetode 63: Unique Path-II

        //Faith:- path(x,y)=path(x+1,y)+path(x,y+1),,,, in case grid[x][y]==0

        int uniquePathMemo(int sr,int sc,int er,int ec,vector<vector<int>> &grid,vector<vector<int>> &dp){
        
        if(sr==er && sc==ec && grid[er][ec]==0){
            return dp[sr][sc]=1;
        }
        
           if(dp[sr][sc]!=-1)
               return dp[sr][sc];
           
        int c=0;
        if(sr+1<=er && grid[sr+1][sc]==0)
        c+=uniquePathMemo(sr+1,sc,er,ec,grid,dp);
        if(sc+1<=ec && grid[sr][sc+1]==0)
        c+=uniquePathMemo(sr,sc+1,er,ec,grid,dp);
        
        return dp[sr][sc]=c;
        }

        long long int uniquePathTabulation(int sr,int sc,int er,int ec,vector<vector<int>> &grid,vector<vector<int>> &dp){
        
        for(sr=er;sr>=0;sr--){
            for(sc=ec;sc>=0;sc--){
            if(sr==er && sc==ec && grid[sr][sc]==0){
            dp[sr][sc]=1;
            continue;
            }
    
            long long int count=0;
            if(sr+1<=er && grid[sr][sc]==0)
            count+=dp[sr+1][sc];
            if(sc+1<=ec && grid[sr][sc]==0)
            count+=dp[sr][sc+1];//uniquePathMemo(sr,sc+1,er,ec,dp);
              
            dp[sr][sc]=count;
        }
        }
        
        return dp[0][0];
        }
    
        int uniquePathsWithObstacles(vector<vector<int>> &obstacleGrid) {
        
        int n=obstacleGrid.size();
        int m=obstacleGrid[0].size();
        
        vector<vector<int>> dp(n,vector<int>(m,0));
        
        if(obstacleGrid[0][0]==1)
            return 0;
        else if(obstacleGrid[n-1][m-1]==1)
            return 0;
        else{
        int ans=uniquePathTabulation(0,0,n-1,m-1,obstacleGrid,dp);
        return ans;
        }
    }
    

// Leetcode 64: Min Path Sum

//Faith:- minCost(x,y)=grid[x][y]+min(minCost(x+1,y),minCost(x,y+1))

    int minPathSumMemo(int sr,int sc,int er,int ec,vector<vector<int>> &grid,vector<vector<int>> &dp){
    
        if(sr==er && sc==ec)
        return dp[sr][sc]=grid[sr][sc];
        
        if(dp[sr][sc]!=-1)
            return dp[sr][sc];
            
        int minCost=1e8;
        
        if(sr+1<=er)
        minCost=min(minCost,minPathSumMemo(sr+1,sc,er,ec,grid,dp));
        if(sc+1<=ec)
        minCost=min(minCost,minPathSumMemo(sr,sc+1,er,ec,grid,dp));
        
        return  dp[sr][sc]=minCost+grid[sr][sc];
    }
    
     int minPathSumDP(int sr,int sc,int er,int ec,vector<vector<int>> &grid,vector<vector<int>> &dp){
        
         for(sr=er;sr>=0;sr--)
         {
          for(sc=ec;sc>=0;sc--){
        
           if(sr==er && sc==ec)
           {
           dp[sr][sc]=grid[sr][sc];
           continue;
           }
           int minCost=1e8;
     
        if(sr+1<=er)
        minCost=min(minCost,dp[sr+1][sc]);
        if(sc+1<=ec)
        minCost=min(minCost,dp[sr][sc+1]);
      
        dp[sr][sc]=minCost+grid[sr][sc];
      }   
    } 
    return dp[0][0];
   }
        
    
    int minPathSum(vector<vector<int>>& grid) {
        int m=grid.size();
        int n=grid[0].size();
        vector<vector<int>> dp(m,vector<int>(n,-1));
        
        int ans=minPathSumDP(0,0,m-1,n-1,grid,dp);
        return ans;
    }

    //Leetcode-70: Climbing Stairs(Java)

    //Faith-- climb(n)=climb(n-1)+climb(n-2)


    public int climbStairs(int n) {
    int dp[]=new int[n+1];
    int ans=climbDP(n,dp);
    return ans;
    }
    
    public int climbMemo(int n,int dp[]){
        
        if(n==0)
        return dp[n]=1;
        
        if(dp[n]!=0)
            return dp[n];
        
        int p1=0,p2=0;
        if(n-1>=0)
        p1=climbMemo(n-1,dp);
        if(n-2>=0)
        p2=climbMemo(n-2,dp);
        int paths=p1+p2;
        
        return dp[n]=paths;
    }
    
    //GFG:- Friends Pairing Problem 

    //Faith:- countPairs(n)=countPairs(n-1)+countPairs(n-2)*(n-1)...

    // https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1#
    
    public long countPairs(int n){
        
        if(n<=1)
        return 1;
        
        long single=countPairs(n-1);
        long pairUp=countPairs(n-2)*(n-1);
        
        long ans=single+pairUp;
        
        return ans;
    }
    
    public long countPairsMemo(int n,long dp[],long M){
        
        if(n<=1)
        return dp[n]=1;
        
        if(dp[n]!=0)
        return dp[n];
        
        long single=countPairsMemo(n-1,dp,M)%M;
        long pairUp=(countPairsMemo(n-2,dp,M)%M*(n-1)%M)%M;
        
        long ans=(single%M+pairUp%M)%M;
        
        return dp[n]=ans;
    
    }
    
    public long countPairsDP(int N,long dp[],long M){
        
        for(int n=0;n<=N;n++){
        
        if(n<=1){
        dp[n]=1;
        continue;
        }
        
        long single=dp[n-1]%M;
        long pairUp=(dp[n-2]%M*(n-1)%M)%M;
        
        long ans=(single%M+pairUp%M)%M;
        
        dp[n]=ans;
        
        }
        return dp[N];
    }
    
    public long countPairsOptimized(int n,long M){
        
        long a=1;
        long b=1;
        
        for(int i=2;i<=n;i++){
            
            long s=((a%M*(i-1)%M)%M+b%M)%M;
            a=b;
            b=s;
        }
        
        return b;
    }
    
    public long countFriendsPairings(int n) 
    { 
       long dp[]=new long[n+1];
       long M=(int)1e9+7;
       //long ans=countPairsMemo(n,dp,M);
    //   for(int e=0;e<dp.length;e++)
    //   System.out.print(dp[e]+" ");
       long ans=countPairsOptimized(n,M);
       return ans;
    }
    
    //Leetcode 746: Min Cost Climbing Stairs

    //If n==length(cost) then add 0 to min obtained else add cost[n]....(I)
    
    //Faith:- minCost(n)=(I)+min(minCost(n-1),minCost(n-2))  

    int minCostClimbingStairs(int n,vector<int>& cost,vector<int>& dp) {
        if(n<=1) 
        return dp[n] = cost[n];
        
        if(dp[n]!=0) 
        return dp[n];
        
        int val = min(minCostClimbingStairs(n-1,cost,dp),minCostClimbingStairs(n-2,cost,dp));
        
        return dp[n] = val +  ((n < cost.size()) ? cost[n] : 0);
    }
    
    int minCostClimbingStairsDP(int N,vector<int>& cost,vector<int>& dp) {
        
        for(int n=0;n<=N;n++){
        if(n<=1) 
        {dp[n] = cost[n];
        continue;
        }
        
        int val = min(minCostClimbingStairs(n-1,cost,dp),minCostClimbingStairs(n-2,cost,dp));
        
        dp[n] = val +  ((n < cost.size()) ? cost[n] : 0);
        
    }
        
        return dp[N];
    }
    
    int minCostClimbingStairs(vector<int>& cost) {
        if(cost.size() == 0) 
            return 0;
        
        int n = cost.size();
        vector<int> dp(n+1,0);
        
        return minCostClimbingStairsDP(n,cost,dp);
}

void twoPointer()
{
    // fibo();
    mazePath();
}

void solve()
{
    twoPointer();
}

int main()
{
    solve();
    return 0;
}