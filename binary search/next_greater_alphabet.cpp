
#include <bits/stdc++.h>
using namespace std;

char next_greater(char ar[],int n,int left,int right,char v){
	char res;
	while(left<=right){
		int mid=left+(right-left)/2;
		if(ar[mid]==v)
			left=mid+1;
		else if(ar[mid]<v)
			left=mid+1;
		else{
			res=ar[mid];
			right=mid-1;
		}
	}
	return res;
}

int main(){
	
	#ifndef ONLINE_JUDGE
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout);
	#endif

	int t;
	cin>>t;
	while(t--){
    int n;
    cin>>n;
    char arr[n];// sorted array of characters
	
	for(int i=0;i<n;i++)
		cin>>arr[i];

    char key;
    cin>>key;

    char next=next_greater(arr,n,0,n-1,key);

    cout<<next<<"\n";
    
	}
}