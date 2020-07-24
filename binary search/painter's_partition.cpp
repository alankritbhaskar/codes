// Dilpreet wants to paint his dog- Buzo's home
// that has n boards with different lengths[A1, A2,..., An]. 
// He hired k painters for this work and each painter takes 1 unit time
// to paint 1 unit of the board.
// The problem is to find the minimum time to get this job done
// under the constraints that any painter will only paint continuous sections
// of boards, say board {2, 3, 4} or only board {1} or nothing 
// but not board {2, 4, 5}.

// Input:
// The first line consists of a single integer T, the number of test cases.
// For each test case, the first line contains an integer k denoting
// the number of painters and integer n denoting the number of boards. 
// Next line contains n- space separated integers denoting the size of boards.

// Output:
// For each test case, the output is an integer 
// displaying the minimum time for painting that house.



#include<bits/stdc++.h>
#define ll long long int
using namespace std;

bool isValid(ll arr[],ll n,ll k,ll mx){
    ll painters=1;
    ll sum=0;
    for(ll i=0;i<n;i++){
        sum+=arr[i];
        if(sum>mx){
            painters++;
            sum=arr[i];    
        }
        if(painters>k)
        return false;
    }
    return true;
}

ll arr_max(ll a[],ll n){
    ll max=LONG_MIN;
    for(ll i=0;i<n;i++){
        if(a[i]>max)
        max=a[i];
    }
    return max;
}

ll sum_arr(ll a[],ll n){
    ll sum=0;
    for(ll x=0;x<n;x++)
    sum+=a[x];
    return sum;
}

ll allocatePainters(ll arr[],ll n,ll k){
    ll res=-1;
    ll start=arr_max(arr,n);
	ll end=sum_arr(arr,n);
	    
	    while(start<=end){
	        ll mid=start+(end-start)/2;
	        if(isValid(arr,n,k,mid)==true){
	         res=mid;
	         end=mid-1;
	        }
	        else
	        start=mid+1;
	    }
	    return res;
}

int main()
 {
 	
 	#ifndef ONLINE_JUDGE
 	freopen("input.txt","r",stdin);
 	freopen("output.txt","w",stdout);
 	#endif

	ll t;
	cin>>t;
	while(t--){
	    ll m,n;
	    cin>>m>>n;
	    
	    ll arr[n];
	    
	    for(ll i=0;i<n;i++)
	    cin>>arr[i];
	    
	    if(m>n)
	    {
	        cout<<arr_max(arr,n)<<"\n";
	    }
	    else{
	    ll ans=allocatePainters(arr,n,m);
	    cout<<ans<<"\n";
	}
	}
	return 0;
}