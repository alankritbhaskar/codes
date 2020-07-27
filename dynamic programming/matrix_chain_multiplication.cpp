#include<bits/stdc++.h>
using namespace std;

int dp[10001][10001];

int mcm(int arr[],int i,int j){
    
    if(i>=j)
    return 0;
    
    if(dp[i][j]!=-1)
    return dp[i][j];
    
    int min=INT_MAX;
    
    int left=0; 
    int right=0;
    int temp=0;
    
    
    for(int k=i;k<j;k++){
        if(dp[i][k]!=-1)
        {
        left=dp[i][k];    
        }
        else
        {
        dp[i][k]=mcm(arr,i,k);
        left=dp[i][k];
        }
        if(dp[k+1][j]!=-1){
            right=dp[k+1][j];
        }
        else{
            dp[k+1][j]=mcm(arr,k+1,j);
            right=dp[k+1][j];
        }
        temp=left+right+(arr[i-1]*arr[k]*arr[j]);
        if(temp<min)
        min=temp;
    }
    return min;
}

int main()
 {
    #ifndef ONLINE_JUDGE
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    #endif
	int t;
	cin>>t;
	while(t--){
	    memset(dp,-1,sizeof(dp));
	    int n;
	    cin>>n;
	    int ar[n];
	    
	    for(int i=0;i<n;i++)
	    cin>>ar[i];
	    
	    int i=1;int j=n-1;
	    int cost=mcm(ar,i,j);
	    cout<<cost<<"\n";
	    
	}
	return 0;
}