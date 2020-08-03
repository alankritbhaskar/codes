// Stock Span Problem a variation of NGL 

/* 
The stock span problem is a financial problem 
where we have a series of n daily price quotes for a stock and we need to
calculate span of stock’s price or all n days.
The span Si of the stock’s price 
on a given day i is defined as 
the maximum number of consecutive days just before 
the given day, for which the price of the stock
on the current day is less than or equal to its price 
on the given day.
For example, if an array of 7 days prices is given
as {100, 80, 60, 70, 60, 75, 85}, 
then the span values for corresponding 
7 days are {1, 1, 1, 2, 1, 4, 6}
*/

#include <bits/stdc++.h>
using namespace std;

int main(){
	
	ios_base::sync_with_stdio(false);
    cin.tie(NULL);

	#ifndef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
	#endif

	int t;
	cin>>t;

	while(t--){

		int n;
		cin>>n;
		int a[n];

		for(int i=0;i<n;i++)
			cin>>a[i];

		stack<pair<int,int>> s;
		vector<int> v;

		for (int i = 0; i < n; ++i)
		{
			if(s.empty())
			{
				v.push_back(-1);
				s.push({a[i],i});
			}
			else{
				if(s.top().first<=a[i]){
					while(!s.empty() && s.top().first<=a[i])
						s.pop();
					if(s.empty())
						v.push_back(-1);
					else
						v.push_back(s.top().second);
					s.push({a[i],i});
				}
				else{
					v.push_back(s.top().second);
					s.push({a[i],i});
				}
			}
		}

        for(int i=0;i<v.size();i++)
        v[i]=i-v[i];
        
		for(int i: v)
			cout<<i<<" ";
		cout<<"\n";
		v.clear();
}
	    return 0;
}
