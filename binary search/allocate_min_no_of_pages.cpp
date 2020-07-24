// Book allocation problem

#include<bits/stdc++.h>
#define ll long long int
using namespace std;

bool isValid(ll arr[],ll n,ll k,ll mx){
    ll students=1;
    ll sum=0;
    for(ll i=0;i<n;i++){
        sum+=arr[i];
        if(sum>mx){
            students++;
            sum=arr[i];    
        }
        if(students>k)
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

ll allocate(ll arr[],ll n,ll k){
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
	ll t;
	cin>>t;
	while(t--){
	    ll n;
	    cin>>n;
	    ll arr[n];
	    for(ll i=0;i<n;i++)
	    cin>>arr[i];
	    ll m;
	    cin>>m;
	    if(m>n)
	    cout<<"-1"<<"\n";
	    else{
	    ll ans=allocate(arr,n,m);
	    
        cout<<ans<<"\n";
	}
	}
	return 0;
}
