#include <bits/stdc++.h>
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

// LIS---- Recursive Approach----> Time:- O(n2)
                             //    Space:- O(n)

// Leetcode 300. LIS

// LIS_Left to right

// Faith:-
// Mai khud se small har element pe jake puchunga ki tum apne pe khatam hone wale 
// longest length ka lis mujhe batado un sab me se largest ke sath me khud ko append krke uski length 1 increase 
// kr dunga

int LIS_rec (vector<int> &arr, int idx, vector<int> &dp){

if (dp[idx] != 0)
    return dp[idx];

int maxLen=1;// har ek element ki khud ki length 1 hai

for(int i=idx-1;i>=0;i--){
    if(arr[i]<arr[idx]){ // for strictly increasing lis 
    int len=LIS_rec(arr,i,dp)+1;
    maxLen=max(maxLen,len);
}
}

return dp[idx]=maxLen;
}

// LIS_Right to left

// Faith:- 
// i will ask all the elements greater than me
// to bring the length of lis starting from them and i will append myself to ahead of them and increase the count by 1.

int lis_RL(vector<int> &arr,int idx,vector<int> &dp){
    if(dp[idx] != -1)
        return dp[idx];

    int maxLen = 1;
    for(int i=idx;i<=arr.size()-1;i++){
        int len = 0;
        if(arr[idx] < arr[i])
        len = lis_RL(arr,i,dp)+1;
        maxLen = max(maxLen,len);
    }
    return dp[idx] = maxLen;
}

int LISRec()
{
    vector<int> arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15, 14};
    int maxLen = 0;

    vector<int> dp(arr.size(), 0);

    // Largest length kisi bhi index pe ho sakti hai not necessarily at last index of array
    // so we perform the operation of above function on the complete array elements

    // Jisse O(n2) ki jaan lag jati hai..........

    for (int i = arr.size(); i >= 0; i--)
    {
        maxLen = max(maxLen, LIS_rec(arr, i, dp));
    }

    // for(int i = 0;i<=arr.size()-1;i++)
    //     maxLen = max(maxLen,lis_RL(arr,i,dp));

    return maxLen;
}

// LIS Tabulation------------> O(n2), O(n)

int LIS(vector<int> &arr, vector<int> &dp)
{
    int n = arr.size();
    
    int maxLen = 0;
    for (int i = 0; i < n; i++)
    {
        dp[i] = 1;
        for (int j = i - 1; j >= 0; j--)
        {
            if (arr[i] > arr[j])
                dp[i] = max(dp[i], dp[j] + 1);
        }
        maxLen = max(maxLen, dp[i]);
    }

    return maxLen;
}

// Longest Decreasing Subsequence, here the frame of reference i.e. how lis from last of array to first element of array
// gives the LDS of array is quite important

int LDS(vector<int> &arr, vector<int> &dp)
{
    int n = arr.size();
    int maxLen = 0;
    for (int i = n - 1; i >= 0; i--)
    {
        dp[i] = 1;
        for (int j = i + 1; j < n; j++)
        {
            if (arr[i] > arr[j])
                dp[i] = max(dp[i], dp[j] + 1);
        }
        maxLen = max(maxLen, dp[i]);
    }

    return maxLen;
}

// Longest Bitonic Subsequence  https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1

	int LongestBitonicSequence(vector<int>nums)
	{
	int n=nums.size();
    vector<int> dp(n,0);
    int ans=LBS(nums,dp);
    return ans;
	}
	
	int LBS(vector<int> &nums,vector<int> &dp){
	    int n=nums.size();
	    
	    vector<int>dp1(n,0);
	    vector<int>dp2(n,0);
        LIS(nums, dp1);
        LDS(nums, dp2);

        int maxLen = 0;
        for (int i = 0; i < n; i++)
        {
        maxLen = max(maxLen, dp1[i] + dp2[i] - 1);
        }

        return maxLen;
	}
	
int LIS(vector<int> &arr, vector<int> &dp)
{
    int n = arr.size();
    
    int maxLen = 0;
    for (int i = 0; i < n; i++)
    {
        dp[i] = 1;
        for (int j = i - 1; j >= 0; j--)
        {
            if (arr[i] > arr[j])
                dp[i] = max(dp[i], dp[j] + 1);
        }
        maxLen = max(maxLen, dp[i]);
    }

    return maxLen;
}
	
int LDS(vector<int> &arr, vector<int> &dp)
{
    int n = arr.size();
    int maxLen = 0;
    for (int i = n - 1; i >= 0; i--)
    {
        dp[i] = 1;
        for (int j = i + 1; j < n; j++)
        {
            if (arr[i] > arr[j])
                dp[i] = max(dp[i], dp[j] + 1);
        }
        maxLen = max(maxLen, dp[i]);
    }

    return maxLen;
}

// https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1

	int maxSumIS(int arr[], int n)  
	{  
	    int dp[n]={0};
	    int ans=LISum(arr,n,dp);
	    return ans;
	}  
	
	int LISum(int a[],int n,int dp[]){
	    
	    int maxSum=0;
	    for(int i= 0;i<n;i++){
	        dp[i] = a[i];
	        for(int j= i-1;j>=0;j--){
	            if(a[j]<a[i]){
	                dp[i]=max(dp[i],dp[j]+a[i]);
	            }
	        }
	        maxSum=max(maxSum,dp[i]);
	    }
	    return maxSum;
	}

    	public int maxSumIS(int arr[], int n){  
	    int dp[] = new int[n+1];
	    Arrays.fill(dp,-1);
	    
	    if(n == 0)
	        return 0;
	        
	    int maxSum = 0;
	    for(int i=0;i<n;i++){
	        maxSum = Math.max(maxSum,lisSum(arr,i,dp));
	    }
	    
	    return maxSum;
	}  
	
	public int lisSum(int arr[],int idx,int dp[]){
	    int maxSum = arr[idx]; // important
	    
	    if(dp[idx] != -1)
	        return dp[idx];
	        
	    for(int i=idx-1;i>=0;i--){
	        int currSum = 0;
	        if(arr[idx] > arr[i])
	            currSum = lisSum(arr,i,dp);
	        maxSum = Math.max(arr[idx]+currSum,maxSum);
	    }
	    
	    return dp[idx] = maxSum;
	}

// https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-to-make-a-sorted-sequence3248/1

	int minDeletions(int arr[], int n) 
	{ 
	    int dp[n]={0};
	    int l=lis(arr,n,dp);
	    return n-l;
	} 
	
	int lis(int a[],int n,int dp[]){
	    
	    int maxLen=0;
	    for(int i=0;i<n;i++){
	        dp[i]=1;
	        for(int j=i-1;j>=0;j--){
	            if(a[j]<a[i])
	            dp[i]=max(dp[i],dp[j]+1);
	        }
	        maxLen=max(dp[i],maxLen);
	    }
	    return maxLen;
	}

	// public int minDeletions(int arr[], int n) 
	// { 
	//    if(n == 0)
	//     return 0;
	//    int lisLen = 0;
	   
	//    int dp[] = new int[n+1];
	//    Arrays.fill(dp,-1);
	   
	//    //for(int i=0;i<n;i++){
	//    //    lisLen = Math.max(lisLen,lis(arr,i,dp));
	//    //}
	   
	//    lisLen = lisDP(arr,n);
	   
	//    int minDel = n-lisLen;
	//    return minDel;
	// } 
	
	// public int lis(int arr[],int idx,int dp[]){
	//     int maxLen = 1;
	    
	//     if(dp[idx] != -1)
	//         return dp[idx];
	        
	//     for(int i=idx;i>=0;i--){
	//         int len = 0;
	//         if(arr[idx] > arr[i])
	//             len = lis(arr,i,dp)+1;
	//         maxLen = Math.max(len,maxLen);
	//     }
	    
	//     return dp[idx] = maxLen;
	// }
	
	// public int lisDP(int arr[],int n){
    // int dp[] = new int[n+1];
    
    // int maxLen = 0;
    // for (int i = 0; i < n; i++)
    // {
    //     dp[i] = 1;
    //     for (int j = i; j >= 0; j--)
    //     {
    //         if (arr[i] > arr[j])
    //             dp[i] = Math.max(dp[i],dp[j]+1);
    //     maxLen = Math.max(maxLen, dp[i]);
    //     }
    // }
    //     return maxLen;
    // }

// Leetcode 354:- Russian Doll Envelopes

int maxEnvelopes(vector<vector<int>>& arr) {
        
        int n=arr.size();
        vector<int> dp(n,0);
        
        sort(arr.begin(),arr.end(),[](auto a,auto b){
            return a[0]<b[0];// this < other,default value
        });
        
        int maxStack=0;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(arr[j][0]<arr[i][0] && arr[j][1]<arr[i][1])
                dp[i]=max(dp[i],dp[j]+1);
            }
            maxStack=max(dp[i],maxStack);
        }
        return maxStack;
    }

// https://www.geeksforgeeks.org/dynamic-programming-building-bridges/

// Same as above problem approach


int main(int argc, const char** argv) {
    int ans=LISRec();
    cout<<ans<<"\n";
    return 0;
}