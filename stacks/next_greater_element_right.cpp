/*Next greater element to right of array

Sample input:- 
2
4
1 3 2 4
7
1 3 0 0 1 2 4

Sample output:-
3 4 4 -1 
3 4 1 1 2 4 -1 

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

		for(int i=n-1;i>=0;i--){

			if(s.empty()){
				s.push(a[i]);
				v.push_back(-1);
			}
			else{

				if(s.top()>a[i]){
                 v.push_back(s.top());
                 s.push(a[i]);
			}
			else{
				while(!s.empty() && s.top()<=a[i])
					s.pop();
				if(s.size()==0)
					v.push_back(-1);
				else
					v.push_back(s.top());
				    s.push(a[i]);
			}
		}
		}
	reverse(v.begin(), v.end());
	
	for (int i = 0; i < v.size(); ++i)
	{
		cout<<v[i]<<" ";
	}
	
	cout<<"\n";
    v.clear();
	}

	    return 0;
}