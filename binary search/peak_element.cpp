// Program to find peak element in an unsorted array
//, and return its 1-based index else -1.

#include <bits/stdc++.h>
using namespace std;

int peak(int arr[],int n,int left,int right){
	        while(left<=right){
        	int mid=left+(right-left)/2;

        	if((mid==0 || arr[mid-1]<=arr[mid]) && (mid==n-1 || arr[mid+1]<=arr[mid]))
        		return mid;
        	else if(mid >0 && arr[mid-1]>arr[mid])
        		right=mid-1;
        	else
        		left=mid+1;
        }
        return -1;
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
    	int arr[n];// unsorted array 
    	
    	for(int i=0;i<n;i++)
    		cin>>arr[i];

        int index=peak(arr,n,0,n-1);

        cout<<index+1<<"\n";

    }

}