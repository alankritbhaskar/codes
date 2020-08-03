/*Next smaller element to left O(N)

Sample input:- 
2
4
1 3 2 4
7
1 3 0 0 1 2 4

Sample output:-
-1 1 1 2 
-1 1 -1 -1 0 1 2 

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

		stack<int> s;
		vector<int> v;

		for (int i = 0; i < n; ++i)
		{
			if(s.empty())
			{
				v.push_back(-1);
				s.push(a[i]);
			}
			else{
				if(s.top()>=a[i]){
					while(!s.empty() && s.top()>=a[i])
						s.pop();
					if(s.empty())
						v.push_back(-1);
					else
						v.push_back(s.top());
					s.push(a[i]);
				}
				else{
					v.push_back(s.top());
					s.push(a[i]);
				}
			}
		}

		for(int i: v)
			cout<<i<<" ";
		cout<<"\n";
		v.clear();
}
	    return 0;
}