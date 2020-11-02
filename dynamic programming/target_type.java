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

// Target Sum (only addition)

//  public int targetSumAdd(int arr[],int ind,int tar,int dp[][]){

//     if(ind==arr.length-1 && tar!=0){
//     return dp[ind][tar]=0;
//     }
//     else if(tar==0){
//         return dp[ind][tar]=1;
//     }
    
//     if(dp[ind][tar]!=-1)
//     return dp[ind][tar];

//     int c=0;
//     if(arr[ind]>tar)
//     c+=targetSumAdd(arr,ind+1,tar,dp);
//     else{
//         c+=targetSumAdd(arr,ind+1,tar-arr[ind],dp)+targetSumAdd(arr,ind+1,tar,dp);
//     }
//     return dp[ind][tar];
// }
//  public int target(int arr[],int tar){
//     int dp[][]=new int[arr.length]
// }


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


    public static void main(String[] args){
        solve();
    }
}
