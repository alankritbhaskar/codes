
// Aggressive Cows(SPOJ)

// Overview:- All the C cows must be placed in the N stalls
// such that the minimum distance between any two of them
// is as large as possible
// Print the largest distance.

// Time complexity:- O(nlogn)

#include <bits/stdc++.h>
#define ll long long int
using namespace std;

bool isValid(ll arr[],int n,ll c,ll minDis){
	ll count=1;ll last=arr[0];
	for (int i = 0; i < n; ++i)
	{
		if(arr[i]-last>=minDis){
			last=arr[i];
			count++;
		}
		if(count==c)
			return true;
	}
	return false;
}

int main(){

	#ifndef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
	#endif

	int t;
	cin>>t;

	while(t--){
		int n,k;
		cin>>n>>k;
		ll barns[n];

		for(int i=0;i<n;i++){
			cin>>barns[i];
		}
		sort(barns,barns+n);

		ll lowerbound=barns[1]-barns[0];
		ll upperbound=barns[n-1]-barns[0];
		ll result=-1;

		while(lowerbound<=upperbound){
			ll mid=lowerbound+(upperbound-lowerbound)/2;
			if(isValid(barns,n,k,mid)){
            result=mid;
            lowerbound=mid+1;
			}
			else{
				upperbound=mid-1;
			}
		}
    cout<<"Max. of the min. distance between cows is :"<<result<<"\n";
	}
}