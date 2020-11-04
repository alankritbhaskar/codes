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

int LIS_rec (vector<int> &arr, int idx, vector<int> &dp){

if (dp[idx] != 0)
    return dp[idx];

int maxLen=1;// har ek element ki khud ki length 1 hai

// Mai khud se small har element pe jake puchunga ki tum apne pe khatam hone wale 
// longest length ka lis mujhe batado un sab me se largest ke sath me khud ko append krke uski length 1 increase 
// kr dunga

for(int i=idx-1;i>=0;i--){
    if(arr[i]<arr[idx]){ // for strictly increasing lis 
    int len=LIS_rec(arr,i,dp)+1;
    maxLen=max(maxLen,len);
}
}

return dp[idx]=maxLen;
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

// Longest Bitonic Subsequence

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

int main(int argc, const char** argv) {
    int ans=LISRec();
    cout<<ans<<"\n";
    return 0;
}