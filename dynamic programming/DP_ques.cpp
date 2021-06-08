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
        
        if(sr==er && sc==ec){
            return dp[sr][sc]=1;
        }
        
           if(dp[sr][sc]!=0)
               return dp[sr][sc];
           
        int c=0;
        if(sr+1<=er && grid[sr+1][sc]==0)
        c+=uniquePathMemo(sr+1,sc,er,ec,grid,dp);
        if(sc+1<=ec && grid[sr][sc+1]==0)
        c+=uniquePathMemo(sr,sc+1,er,ec,grid,dp);
           
        return dp[sr][sc]=c;
        
}
long long int uniquePathDP(int sr,int sc,int er,int ec,vector<vector<int>> &grid,vector<vector<long long int>> &dp){
        
        for(sr=er;sr>=0;sr--){
            for(sc=ec;sc>=0;sc--){
               
        if(sr==er && sc==ec){
         dp[sr][sc]=1;
            continue;
        }
           
        long long int c=0;
        if(sr+1<=er && grid[sr+1][sc]==0)
        c+=dp[sr+1][sc];//uniquePathMemo(sr+1,sc,er,ec,grid,dp);
        if(sc+1<=ec && grid[sr][sc+1]==0)
        c+=dp[sr][sc+1];//uniquePathMemo(sr,sc+1,er,ec,grid,dp);
           
         dp[sr][sc]=c;
            }
        }
        
        return dp[0][0];
}
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
    
    if(obstacleGrid.size()==0 || obstacleGrid[0].size()==0)
    return 0;

    int m=obstacleGrid.size();
    int n=obstacleGrid[0].size();
    if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)      
    return 0;
        
    vector<vector<long long int>> dp(m,vector<long long int> (n,0));
    int ans=uniquePathDP(0,0,m-1,n-1,obstacleGrid,dp);
    return ans;
    
    }
    

// Leetcode 64: Min Path Sum

//Faith:- minCost(x,y)=grid[x][y]+min(minCost(x+1,y),minCost(x,y+1))

    int minPathSumMemo(int sr,int sc,int er,int ec,vector<vector<int>> &grid,vector<vector<int>> &dp){

// if(sr == er && sc == ec)
//     return dp[sr][sc] = grid[sr][sc];
        
// if(dp[sr][sc] != -1)
//     return dp[sr][sc];
        
// int overall = (int)1e8;int right=(int)1e8,down=(int)1e8;
// if(sc+1 <= ec)
// right = minPathMemo(sr,sc+1,er,ec,grid,dp);
// if(sr+1 <= er)
// down = minPathMemo(sr+1,sc,er,ec,grid,dp);
        
// overall = grid[sr][sc]+min(right,down);
// return dp[sr][sc] = overall;

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

    //Leetcode-70: Climbing Stairs

    //Faith-- climb(n)=climb(n-1)+climb(n-2)

    int climbStairs(int n) {
        if(n == 0)
            return 0;
        vector<int> dp(n+1,-1);
        int ans = climbDP(n,dp);
        return ans;
    }
    
    int climb(int n,vector<int> &dp){
        if(n == 0)
            return dp[n] = 1;
        
        if(dp[n] != -1)
            return dp[n];
        
        int one = 0,two = 0;
        int ways=0;
        
        if(n-1 >= 0)
            one = climb(n-1,dp);
        if(n-2 >= 0)
            two = climb(n-2,dp);
        
        ways = one+two;
        return dp[n] = ways;
    }
    
    int climbDP(int N,vector<int> &dp){
        for(int n = 0;n <= N;n++){

        if(n == 0)
        {dp[n] = 1;
        continue;
        }
        
        int one = 0,two = 0;
        int ways=0;
        
        if(n-1 >= 0)
            one = dp[n-1];//climb(n-1,dp);
        if(n-2 >= 0)
            two = dp[n-2];//climb(n-2,dp);
        
        ways = one+two;
        dp[n] = ways;
        continue;
        }
        return dp[N];
    }

// Leetcode 198:- House Robber

    int rob(vector<int>& nums) {
       
        int n=nums.size();
        if(n==0)
            return 0;
        
        vector<int> dp(n+1,-1);
        int ans=robDP(nums,n,dp);
        return ans;
    }
    
    //Faith:- robMemo(n)=Math.max(robMemo(n-2)+house[n],robMemo(n-1))
    
    int robMemo(vector<int> &nums,int n,vector<int> &dp){
        
        if(n==1 || n==2){
            if(n==1)
            return dp[n]=nums[n-1];
            return dp[n]=max(nums[n-1],nums[n-2]);
        }
        
        if(dp[n] != -1)
            return dp[n];
        
        int amt=0;
        amt=max(nums[n-1]+robMemo(nums,n-2,dp),robMemo(nums,n-1,dp));
        return dp[n]=amt;
    }
    
    int robDP(vector<int> &nums,int n,vector<int> &dp){
        
        for(int i=1;i<=n;i++){
        if(n==1 || n==2){
            if(n==1)
            {dp[n]=nums[n-1];
             continue;
            }
            dp[n]=max(nums[n-1],nums[n-2]);
            continue;
        }
        
        int amt=0;
        amt=max(nums[n-1]+robMemo(nums,n-2,dp),robMemo(nums,n-1,dp));
        dp[n]=amt;
    }
        return dp[n];
    }
    
//GFG:- Friends Pairing Problem 

//Faith:- countPairs(n)=countPairs(n-1)+countPairs(n-2)*(n-1)...
// https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1#

    const int mod = (int)(1e9+7);
    
    int countFriendsPairings(int n) 
    {   
        vector<int> dp(n+1,-1);
        int ans = (int)friends(n,dp);
        return ans;
    }

// Faith:- friends(n) = friends(n-1)+friends(n-2)*(n-1)

    long friends(int n,vector<int> &dp){
        if(n == 0 || n == 1)
            return dp[n] = 1;
            
        if(dp[n] != -1)
            return dp[n];
        
        long ways = 0;
        long single = 0, paired = 0;
        if(n-1 >= 0)
        single = friends(n-1,dp)%mod;
        if(n-2 >= 0)
        paired = (friends(n-2,dp)%mod*(n-1)%mod)%mod;
        
        ways = (single%mod + paired%mod)%mod;
        return dp[n]= ways;
    }

// ........................................................
    
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

// Mobile Numeric Keypad
// https://practice.geeksforgeeks.org/problems/mobile-numeric-keypad5456/1

    // Faith:- mobKeypadMemo(sr,sc,n) = mobKeypad(sr+d,sc+d,n-1)
    public long mobKeypadMemo(int sr,int sc,int n,long dp[][],int keypad[][]){
        if(n == 1)
            return dp[keypad[sr][sc]][n] = 1;
        
        if(dp[keypad[sr][sc]][n] != -1)
            return dp[keypad[sr][sc]][n];
        
        long u = 0, r = 0, d = 0, l = 0;
        int m1 = keypad.length;
        int n1 = keypad[0].length;
        
        long mine = mobKeypadMemo(sr,sc,n-1,dp,keypad);
        
        if(sr-1 >=0 && keypad[sr-1][sc] != -1) // up
            u = mobKeypadMemo(sr-1,sc,n-1,dp,keypad);
        if(sc+1 < n1 && keypad[sr][sc+1] != -1) // right
            r = mobKeypadMemo(sr,sc+1,n-1,dp,keypad);
        if(sr+1 < m1 && keypad[sr+1][sc] != -1) // down
            d = mobKeypadMemo(sr+1,sc,n-1,dp,keypad);
        if(sc-1 >= 0 && keypad[sr][sc-1] != -1) // left
            l = mobKeypadMemo(sr,sc-1,n-1,dp,keypad);
        
        return dp[keypad[sr][sc]][n] = mine+u+r+d+l;
    }
    
	public long getCount(int n)
	{   
	    int keypad[][] = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
	    
		long dp[][] = new long[10][n+1];
		
		for(long d[]: dp)
		    Arrays.fill(d,-1);
		
		long ans = 0;
		
		for(int sr = 0; sr < keypad.length;sr++){
		    for(int sc = 0;sc < keypad[0].length;sc++){
		        if(keypad[sr][sc] != -1){
		            ans += mobKeypadMemo(sr,sc,n,dp,keypad);
		        }
		    }
		}
		return ans;
	}

// GFG:- GoldMine Problem....  https://www.geeksforgeeks.org/gold-mine-problem/

// Faith:- goldmine(x,y)=gold[x][y] + max{goldmine(x-1,y+1),goldmine(x,y+1),goldmine(x+1,y+1)}


int goldMine(int r, int c, int n, int m, vector<vector<int>> &arr, vector<vector<int>> &dp, vector<vector<int>> &dir)
{
    if (c == m - 1)
    {
        return dp[r][c] = arr[r][c];
    }

    if (dp[r][c] != 0)
        return dp[r][c];

    int maxVal = 0;
    for (int d = 0; d < 3; d++)
    {
        int x = r + dir[d][0];
        int y = c + dir[d][1];

        if (x >= 0 && y >= 0 && x < n && y < m)
        {
            maxVal = max(maxVal, goldMine(x, y, n, m, arr, dp, dir) + arr[r][c]);
        }
    }

    return dp[r][c] = maxVal;
}

int goldMineDP(int R, int C, int n, int m, vector<vector<int>> &arr, vector<vector<int>> &dp, vector<vector<int>> &dir)
{
    for (int c = C - 1; c >= 0; c--)
    {
        for (int r = R - 1; r >= 0; r--)
        {
            if (c == m - 1)
            {
                dp[r][c] = arr[r][c];
                continue;
            }

            int maxVal = 0;
            for (int d = 0; d < 3; d++)
            {
                int x = r + dir[d][0];
                int y = c + dir[d][1];

                if (x >= 0 && y >= 0 && x < n && y < m)
                {
                    maxVal = max(maxVal, dp[x][y] + arr[r][c]);
                }
            }

            dp[r][c] = maxVal;
        }
    }

    int maxVal = 0;
    for (int r = 0; r < n; r++)
    {
        maxVal = max(maxVal, dp[r][0]);
    }
}

void goldMine()
{
    vector<vector<int>> arr;
    int n = arr.size();
    int m = arr[0].size();

    vector<vector<int>> dp(n, vector<int>(m, 0));
    vector<vector<int>> dir{{-1, 1}, {0, 1}, {1, 1}};

    int maxVal = 0;
    for (int r = 0; r < n; r++)
    {
        maxVal = max(maxVal, goldMine(r, 0, n, m, arr, dp, dir));
    }

    cout << maxVal << endl;
}

//GFG:- NO. of hops    https://practice.geeksforgeeks.org/problems/count-number-of-hops-1587115620/1/?track=amazon-dynamic-programming&batchId=192

# define ll long long int
const ll mod = (ll)(1e9+7);

// function to count number of ways to reach top of the stair
ll hops(int n,vector<ll> &dp){
    if(n == 0)
        return dp[n] = 1;
    
    if(dp[n] != -1)
        return dp[n];
        
    ll ways = 0;ll one = 0, two = 0, three = 0;
    
    if(n-1 >= 0)
    one = hops(n-1,dp);
    if(n-2 >= 0)
        two = hops(n-2,dp);
    if(n-3 >= 0)
        three = hops(n-3,dp);
    
    ways = (one%mod+two%mod+three%mod)%mod;
    return dp[n] = ways;
}

long long countWays(int n){
    vector<ll> dp(n+1,-1);
    ll ans = hops(n,dp);
    return ans;
}

long long countWays(int n){
    
    // your code here
    long long dp[n+1];
    dp[0]=1;
    for(int i=1;i<=n;i++){
        if(i==1)
        dp[i]=dp[i-1]%mod;
        else if(i==2)
        dp[i]=(dp[i-1]%mod+dp[i-2]%mod)%mod;
        else
        dp[i]=(dp[i-1]%mod+dp[i-2]%mod+dp[i-3]%mod)%mod;
    }
    return dp[n];
    
}

//GFG:-  Count ways to reach nth stair   https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1/?track=amazon-dynamic-programming&batchId=192 

long long countWays(int m){
    
    long long int dp[m+1];
    
    dp[0]=1;
    for(int i=1;i<=m;i++){
        if(i==1)
        dp[i]=dp[i-1]%1000000007;
        else{
            dp[i]=(dp[i-1]%1000000007+dp[i-2]%1000000007)%1000000007;
        }
    }
    return dp[m];
}

// Leetcode 53:- Maximum SubArray

    //Kadane's Algorithm
    
    int maxSubArray(vector<int>& nums) {
        
        int sum=0;//instantaneos sum
        int maxi=nums[0];//overall largest sum 
        
        for(int i: nums){
            sum+=i;
            maxi=max(maxi,sum);
            if(sum<0)
                sum=0;
        }
        return maxi;
        
    }

// GFG:- Max. path sum    https://practice.geeksforgeeks.org/problems/path-in-matrix3805/1#

  int maximumPath(int N, vector<vector<int>> grid)
    {
    int n = N;
    int m = N;

    vector<vector<int>> dp(n, vector<int>(m, 0));
    vector<vector<int>> dir{{1, -1}, {1,0}, {1, 1}};

    int maxVal = -(int) 1e8;
    for (int c = 0; c < m; c++)
    {
        maxVal = max(maxVal, maxPathMemo(0, c, n, m, grid, dp, dir));
    }
    return maxVal;
    }
    
    int maxPathMemo(int r, int c, int n, int m, vector<vector<int>> &arr, vector<vector<int>> &dp, vector<vector<int>> &dir)
    {
    if (r == n - 1)
    {
        return dp[r][c] = arr[r][c];
    }

    if (dp[r][c] != 0)
        return dp[r][c];

    int maxVal = -(int)1e8;
    for (int d = 0; d < 3; d++)
    {
        int x = r + dir[d][0];
        int y = c + dir[d][1];

        if (x >= 0 && y >= 0 && x < n && y < m)
        {
            maxVal = max(maxVal, maxPathMemo(x, y, n, m, arr, dp, dir) + arr[r][c]);
        }
    }

    return dp[r][c] = maxVal;
}

// Count no. of paths to reach end on dice throw

int countWays(int sp,int ep,vector<int> &dp){
    if(sp==ep)
    return dp[sp]=1;
    
    if(dp[sp]!=0){
        return dp[sp];
    }

    int c=0;
    for(int dice=1;dice<=6 && sp+dice<=ep;dice++){
        c+=countWays(sp+dice,ep,dp);
    }
    return dp[sp]=c;
}

int countWaysDP(int sp,int ep,vector<int> &dp){

for(sp=ep;sp>=0;sp--){

    if(sp==ep){
    dp[sp]=1;
    continue;
    }

    int c=0;
    for(int dice=1;dice<=6 && sp+dice<=ep;dice++){
        c+=countWays(sp+dice,ep,dp);
    }
    dp[sp]=c;
 }
 
 return dp[0];
}

int countWaysOptimized(int n){

}

    int numDecodings(string s) {
        if(s.length() == 0)
            return 0;
        vector<int> dp(s.length()+1,-1);
        int ans = decode(s,dp,0);
        return ans;
    }
    
    int decode(string s,vector<int> &dp,int idx){
        if(idx == s.length())
            return dp[idx]=1;
        
        if(dp[idx] != -1)
            return dp[idx];
        
        int ways = 0;
        
        char ch1 = s[idx];
        int v1 = (int)(ch1-'0');
        if(ch1 == '0')
            return 0;
        ways += decode(s,dp,idx+1);
        if(v1 <= 2){
            if(idx+2 <= s.length()){
            char ch2 = s[idx+1];
            int v2 = ch2-'0';
           //cout<<v1<<","<<v2<<".";
            if(10*v1+v2 <= 26)
                ways += decode(s,dp,idx+2); 
        }
        }
        return dp[idx] = ways;   
    }

// Count number of ways to partition a set into k subsets
// https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/

    int partition(int n,int k,vector<vector<int>> &dp){
        if(k == 1 || n == k)
            return dp[n][k] = 1;
        
        if(dp[n][k] != -1)
            return dp[n][k];
        
        // very similar to friends pairing
        int single = partition(n-1,k-1,dp);// i will make my singleton subset
        int pairUp = partition(n-1,k,dp)*k;// i myself will go to any of k subsets 

        int ans = single+pairUp;
        return dp[n][k] = ans;
    }

    int minimumTotal(vector<vector<int>>& triangle) {
        if(triangle.size() == 0 || triangle[0].size() == 0)
            return 0;
        
        vector<vector<int>> dp(triangle.size()+1,vector<int> (triangle.size()+1,-1));
        int ans = minTri(triangle,0,0,dp);
        return ans;
    }
    
// Faith:- minTri()- gives me min path sum from top to bottom in next row possible position. I will add myself in this answer
    
    int minTri(vector<vector<int>> &tri,int row,int col,vector<vector<int>> &dp){
        if(row == tri.size()-1)
            return dp[row][col] = tri[row][col];
        
        if(dp[row][col] != -1)
            return dp[row][col];
        
        int minPath = (int)1e9;
        int same = 0;
        int right = 0;
            
        same = minTri(tri,row+1,col,dp);
        if(col <= row)
        right = minTri(tri,row+1,col+1,dp);
        
        minPath = min(same,right)+tri[row][col];
        
        return dp[row][col] = minPath;  
    }

    
// https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps4102/1/?track=amazon-dynamic-programming&batchId=192





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
