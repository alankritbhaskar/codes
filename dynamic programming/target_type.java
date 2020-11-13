import java.util.*;

public class target_type{

 public static void print(int[] arr){
        for(int ele: arr)
          System.out.print(ele + " "); 
        
        System.out.println();
    }

 public static void print2D(int[][] arr){
        for(int[] a: arr)
          print(a);

        System.out.println();
    }

// Coin change( Permutations ):-

/*

For example, if the coins are {2,3,5} and the desired sum is 9, there are 8 ways:

2 + 2 + 5
2 + 5 + 2
5 + 2 + 2
3 + 3 + 3
2 + 2 + 2 + 3
2 + 2 + 3 + 2
2 + 3 + 2 + 2
3 + 2 + 2 + 2

*/

// 2D Approach:-

public static int coinChangePermutations2D(int coins[],int n,int tar,int dp[][]){

    if(tar==0)
    return dp[n][tar]=1;
    

    if(dp[n][tar]!=-1)
    return dp[n][tar];

    int ways=0;

    for(int coin: coins){
    if(tar-coin>=0)
    ways+=coinChangePermutations2D(coins,n,tar-coin,dp);
    }

    return dp[n][tar]=ways;
}

// 1D Approach(better):-

 public static int coinChangePermutations1D(int coins[],int tar,int dp[]){

 if(tar==0)
 return dp[tar]=1;

 if(dp[tar]!=-1)
 return dp[tar];

 int ways=0;

 for(int coin: coins){
     if(tar-coin>=0)
     ways+=coinChangePermutations1D(coins,tar-coin,dp);
 }
 return dp[tar]=ways;
 }

 public static int coinChangePermutations1D_DP(int coins[],int Tar,int dp[]){

     for(int tar=0;tar<=Tar;tar++){
    
       if(tar==0)
       {
           dp[tar]=1;
           continue;
       }

    int ways=0;

    for(int coin: coins){
      if(tar-coin>=0)
       ways+=coinChangePermutations1D(coins,tar-coin,dp);
    }
    dp[tar]=ways;
     }
     return dp[Tar];
 }

 public static int coinChangePermutationDP(int[] arr,int Tar,int[] dp){
        dp[0] = 1;
        for(int tar = 1; tar <= Tar; tar++){
            for(int ele : arr){
                if(tar - ele >= 0){
                    dp[tar] += dp[tar-ele];
                }
            }            
        }

        return dp[Tar];
    }

// Coin Change(Combination):-

/*

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.

*/

 public static int coinChangeCombinationDP(int[] arr,int Tar,int[] dp){
        dp[0] = 1;

         for(int ele : arr){
            for(int tar = 1; tar <= Tar; tar++){
                    dp[tar] += dp[tar-ele];
            }            
        }
        return dp[Tar];
    }

// Leetcode 377:- Combination Sum-IV

 //Don't confuse with the question name it is asking about all the permutations
    
    public int combinationSum4(int[] nums, int target) {
        int dp[]=new int[target+1];
        Arrays.fill(dp,-1);
        int ans=coinChangePermutations1D(nums,target,dp);
        return ans;
    }
    
    public int coinChangePermutations1D(int coins[],int tar,int dp[]){

     if(tar==0)
       return dp[tar]=1;

     if(dp[tar]!=-1)
       return dp[tar];

     int ways=0;

     for(int coin: coins){
       if(tar-coin>=0)
       ways+=coinChangePermutations1D(coins,tar-coin,dp);
     }
     return dp[tar]=ways;
   }

// https://practice.geeksforgeeks.org/problems/reach-a-given-score/0#

int reachScore(vector<int> &scores,int n,vector<int> &dp){
 dp[0]=1;
 for(int score: scores){
     for(int i=score;i<=n;i++){
        dp[i]+=dp[i-score];
     }
 }
 return dp[n];
    
}
int reachScoreSolve(int n){
    vector<int> dp(n+1,0);
    vector<int> scores({3,5,10});
    int ans=reachScore(scores,n,dp);
    return ans;
}

// https://practice.geeksforgeeks.org/problems/count-ways-to-nth-stairorder-does-not-matter5639/1

    public long nthStair(int n)
    {
    
    int jumps[]={1,2};
    int dp[]=new int[n+1];
    long ans=countCombinations(jumps,n,dp);
    return ans;
    }
     public static long countCombinations(int[] arr,int Tar,int[] dp){
        dp[0] = 1;
        for(int ele : arr){
        for(int tar = ele; tar <= Tar; tar++){
                    dp[tar] += dp[tar-ele];
            }            
        }

        return dp[Tar];
    }

// Leetcode 322:- Coin change(min. no. of coins combination)

public int coinChange(int[] coins, int amount) {
        
        int dp[]=new int[amount+1];
        Arrays.fill(dp,-1);
        
        int ans=minCoinChangeDP(coins,amount,dp);
        return ans==(int)1e9?-1:ans;
    }
    
    public int minCoinChange(int coins[],int amt,int dp[]){
        
        if(amt==0)
            return dp[amt]=0;
        
        if(dp[amt]!=-1)
            return dp[amt];
        
        // Dhyan dene ki baat hai ki yaha min ko 1e9 se initialize kiya hai not with INT_MAX bcoz us case mein +1 krne pe integer overflow hojayega
        
        // Agar aisa nhi krna chahte hai to...
        
        //int val=minCoinChange(coins,amt-coin,dp);
        //if(val!=INT_MAX && val+1<min_)
        //min_=val+1;
        
        int min_=(int)1e9;
        for(int coin: coins){
            if(amt-coin>=0)
                min_=Math.min(min_,minCoinChange(coins,amt-coin,dp)+1);
        }
        return dp[amt]=min_;
    }
    
    public int minCoinChangeDP(int coins[],int Amt,int dp[]){
        
        for(int amt=0;amt<=Amt;amt++){
        
        if(amt==0)
        {dp[amt]=0;
         continue;
        }
        
        int min_=(int)1e9;
        for(int coin: coins){
            if(amt-coin>=0)
                min_=Math.min(min_,dp[amt-coin]+1);
        }
            
        dp[amt]=min_;
    }
    return dp[Amt];
}


//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/  i.e. only addition allowed

    public static int targetSum(int[] arr,int idx,int tar,int[][] dp){
        if(tar == 0 || idx == arr.length){
            return dp[idx][tar] = tar == 0 ? 1 : 0;
        }

        if(dp[idx][tar] != -1) return dp[idx][tar];

        int count = 0;
        if(tar - arr[idx] >= 0)
          count += targetSum(arr,idx+1,tar - arr[idx], dp);
        count += targetSum(arr,idx+1,tar, dp);

        return dp[idx][tar] = count;
    }

    public static int targetSumDP(int[] arr,int Idx,int Tar,int[][] dp){
        for(int idx = arr.length;idx >= 0;idx--){
            for(int tar = 0;tar<=Tar;tar++){
                if(tar == 0 || idx == arr.length){
                    dp[idx][tar] = (tar == 0) ? 1 : 0;
                    continue;
                }
                
                int count = 0;
                if(tar - arr[idx] >= 0)
                   count += dp[idx + 1][tar-arr[idx]];
                count += dp[idx + 1][tar];
               
                dp[idx][tar] = count;
            }
        }

        return dp[Idx][Tar];
    }


    public static int targetSum2(int[] arr,int n,int tar,int[][] dp){
        if(tar == 0 || n == 0){
            return dp[n][tar] = (tar == 0) ? 1 : 0;
        }

        if(dp[n][tar] != -1) return dp[n][tar];

        int count = 0;
        if(tar - arr[n - 1] >= 0)
          count += targetSum2(arr,n - 1,tar - arr[n - 1], dp);
        count += targetSum2(arr,n - 1,tar, dp);

        return dp[n][tar] = count;
    }

    public static int targetSumDP2(int[] arr,int N,int Tar,int[][] dp){
        for(int n = 0;n<=N;n++){
            for(int tar = 0;tar<=Tar;tar++){
                if(tar == 0 || n == 0){
                    dp[n][tar] = (tar == 0) ? 1 : 0;
                    continue;
                }
                
                int count = 0;
                if(tar - arr[n - 1] >= 0)
                   count += dp[n-1][tar-arr[n-1]];
                count += dp[n-1][tar];
               
                dp[n][tar] = count;
            }
        }

        return dp[N][Tar];
    }

// For single target sum path (a way to reverse engineer from dp)

    public static boolean targetSumPath(int[] arr,int n,int tar,int[][] dp,String psf){
        if(tar == 0 || n == 0){
           if(tar == 0){
            System.out.println(psf);
            return true;
           }
           return false;
        }

        boolean res = false;
        if(tar - arr[n - 1] >= 0 && dp[n-1][tar - arr[n-1]] > 0)
          res = res || targetSumPath(arr,n - 1,tar - arr[n - 1], dp, psf + arr[n-1] + ",");
        if(dp[n-1][tar] > 0) res = res || targetSumPath(arr,n - 1,tar, dp,psf);

        return res;
    }

// For all target sum paths

    public static int targetSumPath(int[] arr,int n,int tar,int[][] dp,String psf){
        if(tar == 0 || n == 0){
           if(tar == 0){
            System.out.println(psf);
            return 1;
           }
           return 0;
        }

        int res = 0;
        if(tar - arr[n - 1] >= 0 && dp[n-1][tar - arr[n-1]] > 0)
          res += targetSumPath(arr,n - 1,tar - arr[n - 1], dp, psf + arr[n-1] + ",");
        if(dp[n-1][tar] > 0) 
        res += targetSumPath(arr,n - 1,tar, dp,psf);

        return res;
    }

// Leetcode 416:- Partition Equal Subset Sum

 public boolean canPartition(int[] arr) {
        int N = arr.length;
        if(N==0) return false;

        int sum = 0;
        for(int ele : arr) sum+=ele;
        if(sum % 2 != 0) return false;

        int Tar = sum / 2;
        boolean[][] dp = new boolean[N + 1][Tar + 1];

        for(int n = 0;n<=N;n++){
            for(int tar = 0;tar<=Tar;tar++){
                if(tar == 0 || n == 0){
                    dp[n][tar] = (tar == 0) ? true : false;
                    continue;
                }
                
                int count = 0;
                if(tar - arr[n - 1] >= 0)
                   dp[n][tar] = dp[n][tar] || dp[n-1][tar-arr[n-1]];
                dp[n][tar] = dp[n][tar] ||  dp[n-1][tar];               
            }
        }
        System.out.print(dp[N][Tar]);
        return dp[N][Tar];
    }

//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

    public static int knapsack01(int[] weight,int[] value,int n,int tar,int[][] dp){
        
        if(n == 0 || tar == 0){
            return dp[n][tar] = 0;
        }

        if(dp[n][tar] != -1) return dp[n][tar];

        int maxValue = 0;
        if(tar - weight[n - 1] >= 0)
           maxValue = knapsack01(weight,value,n - 1,tar - weight[n - 1],dp) + value[n - 1];
        maxValue = Math.max(maxValue, knapsack01(weight,value,n - 1,tar,dp));
        
        return dp[n][tar] = maxValue;
    }
    
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int dp[][]=new int[n+1][W+1];
        for(int d[]: dp)
        Arrays.fill(d,-1);
        int ans=knapsack01(wt,val,n,W,dp);
        return ans;
        
    }



// https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/

  public static int unboundedKnapsack(int[] weight,int[] val,int Tar){
        int[] dp = new int[Tar+1];
        
        for(int i = 0;i<weight.length;i++){   
           for(int tar = weight[i];tar <= Tar;tar++){
               dp[tar] = Math.max(dp[tar],dp[tar - weight[i]] + val[i]);
           }
        }

        return dp[Tar];
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int ans=unboundedKnapsack(wt,val,W);
        return ans;
    }

    public static int solve(){
        int ar[]={2,3,5};
        int tar=9;
        int dp[][]=new int[ar.length+1][tar+1];
        
        for(int d[]:dp)
        Arrays.fill(d,-1);
        int dpp[]=new int[tar+1];
        Arrays.fill(dpp,-1);
         int dppp[]=new int[tar+1];
         Arrays.fill(dppp,-1);
        int ans=coinChangePermutations2D(ar,3,tar,dp);
        int ans1=coinChangePermutations1D_DP(ar,tar,dpp);
        int ans2=coinChangePermutations1D(ar,tar,dppp);
        print2D(dp);
         System.out.println(ans);
        print(dpp);
         System.out.println(ans1);
         print(dppp);
          System.out.println(ans2);
      
        // targetSum();
        return ans;
    }




    public static void main(String[] args){
        solve();
    }
}
